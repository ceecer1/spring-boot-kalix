package com.example.deal.domain;

import com.example.deal.api.DealApi;
import com.example.deal.domain.base.AbstractDealEntity;
import jdk.jfr.Timestamp;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity.Effect;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;

import java.time.Instant;
import java.util.UUID;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Event Sourced Entity Service described in your com/example/deal/api/deal_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealEntity extends AbstractDealEntity {

  @SuppressWarnings("unused")
  private final String entityId;

  public DealEntity(EventSourcedEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public DealDomain.DealState emptyState() {
    return DealDomain.DealState.getDefaultInstance();
  }

  @Override
  public Effect<DealApi.DealStatus> createDeal(DealDomain.DealState currentState, DealApi.DealRequest dealRequest) {
    DealDomain.DealState state = convertDealRequestToDomain(dealRequest);
//    StateMachineScenario singleton = StateMachineScenario.getInstance();
//    LOG.info(String.format("Singleton status before handling command id %s is %s", commandContext().entityId(), singleton.getStatus()));
//    singleton.setStatus(dealRequest.getChannel());
//    LOG.info(String.format("Singleton status after handling command id %s is %s", commandContext().entityId(), singleton.getStatus()));

    DealDomain.DealSubmitted event =
            DealDomain.DealSubmitted.newBuilder()
                    .setDealIdx(String.valueOf(UUID.randomUUID()))
                            .setModifiedTimestamp(Timestamp.MILLISECONDS_SINCE_EPOCH)
                                    .build();

    return effects()
            .emitEvent(event)
            .thenReply(newState -> convertToApi(state));
  }

  @Override
  public Effect<DealApi.DealStatus> getDeal(DealDomain.DealState currentState, DealApi.GetDealRequest getDealRequest) {
    return effects().error("The command handler for `GetDeal` is not implemented, yet");
  }

  @Override
  public DealDomain.DealState dealSubmitted(DealDomain.DealState currentState, DealDomain.DealSubmitted dealSubmitted) {
    throw new RuntimeException("The event handler for `DealSubmitted` is not implemented, yet");
  }
  @Override
  public DealDomain.DealState dealPaid(DealDomain.DealState currentState, DealDomain.DealPaid dealPaid) {
    throw new RuntimeException("The event handler for `DealPaid` is not implemented, yet");
  }
  @Override
  public DealDomain.DealState dealFulfilled(DealDomain.DealState currentState, DealDomain.DealFulfilled dealFulfilled) {
    throw new RuntimeException("The event handler for `DealFulfilled` is not implemented, yet");
  }
  @Override
  public DealDomain.DealState dealCancelled(DealDomain.DealState currentState, DealDomain.DealCancelled dealCancelled) {
    throw new RuntimeException("The event handler for `DealCancelled` is not implemented, yet");
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

}
