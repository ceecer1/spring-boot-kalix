package com.example.deal.domain;

import com.example.deal.api.DealApi;
import com.example.deal.fsm.FSMEventSourcedEntity;
import com.google.protobuf.Empty;
import kalix.javasdk.valueentity.ValueEntityContext;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Value Entity Service described in your com/example/deal/api/deal_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealEntity extends AbstractDealEntity {
  @SuppressWarnings("unused")
  private final String entityId;

  public DealEntity(ValueEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public DealDomain.DealState emptyState() {
    return DealDomain.DealState.getDefaultInstance();
  }

  @Override
  public Effect<DealApi.DealStatus> createDeal(DealDomain.DealState currentState, DealApi.DealRequest dealRequest) {
    DealDomain.DealState state = convertDealRequestToDomain(dealRequest);
    return effects().updateState(state).thenReply(convertToApi(state));
  }

  private DealDomain.DealState convertDealRequestToDomain(DealApi.DealRequest dealRequest) {
    final String instantAsString = Instant.now().toString();
    return DealDomain.DealState.newBuilder()
            .setDealIdx(commandContext().entityId())
            .setCreatedTimestamp(instantAsString)
            .setModifiedTimestamp(instantAsString)
            .setLifecycleStatus("STATUS_UNKNOWN")
            .setBrand(dealRequest.getBrand())
            .setChannel(dealRequest.getChannel())
            .build();
  }

  @Override
  public Effect<DealApi.DealStatus> getDeal(DealDomain.DealState currentState, DealApi.GetDealRequest getDealRequest) {
    if (currentState.getDealIdx().equals("")) {
      return effects().error("Deal " + getDealRequest.getDealIdx() + " has not been created.");
    } else {
      return effects().reply(convertToApi(currentState));
    }
  }

  private DealApi.DealStatus convertToApi(DealDomain.DealState state) {
    return DealApi.DealStatus.newBuilder()
            .setDealIdx(state.getDealIdx())
            .setCreatedTimestamp(state.getCreatedTimestamp())
            .setModifiedTimestamp(state.getModifiedTimestamp())
            .setLifecycleStatus(state.getLifecycleStatus())
            .setBrand(state.getBrand())
            .setChannel(state.getChannel())
            .build();
  }
}
