package com.example.deal.domain;

import com.example.deal.api.DealApi;
import com.google.protobuf.Empty;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity.Effect;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Date;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Event Sourced Entity Service described in your com/example/deal/api/deal_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealEntity extends AbstractDealEntity {

  private static final Logger LOG = LoggerFactory.getLogger(DealEntity.class);
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
  public Effect<Empty> createDeal(DealDomain.DealState currentState, DealApi.DealRequest dealRequest) {
    LOG.info("During create deal");
//    DealDomain.DealState state = convertDealRequestToDomain(dealRequest);
    DealDomain.DealSubmitted state = DealDomain.DealSubmitted.newBuilder()
            .setDealIdx(this.entityId)
            .setModifiedTimestamp(Instant.now().toString())
            .setStatus(dealRequest.getStatus())
            .build();
    return effects().emitEvent(state).thenReply(newState -> Empty.getDefaultInstance());
  }

  private DealDomain.DealState convertDealRequestToDomain(DealApi.DealRequest dealRequest) {
    final String instantAsString = Instant.now().toString();
    return DealDomain.DealState.newBuilder()
            .setDealIdx(commandContext().entityId())
            .setCreatedTimestamp(instantAsString)
            .setModifiedTimestamp(instantAsString)
            .setLifecycleStatus(dealRequest.getLifecycleStatus())
            .setBrand(dealRequest.getBrand())
            .setChangedBy(dealRequest.getChangedBy())
            .setStatus(dealRequest.getStatus())
            .build();
  }

  private DealApi.DealStatus convertToApi(DealDomain.DealState state) {
    return DealApi.DealStatus.newBuilder()
            .setDealIdx(state.getDealIdx())
            .setCreatedTimestamp(state.getCreatedTimestamp())
            .setModifiedTimestamp(state.getModifiedTimestamp())
            .setLifecycleStatus(state.getLifecycleStatus())
            .setBrand(state.getBrand())
            .setChangedBy(state.getChangedBy())
            .setStatus(state.getStatus())
            .build();
  }

  @Override
  public Effect<Empty> pay(DealDomain.DealState currentState, DealApi.PayDeal payDeal) {
    return null;
  }

  @Override
  public Effect<Empty> submit(DealDomain.DealState currentState, DealApi.SubmitDeal submitDeal) {
    LOG.info(String.format("Deal submit command with id %s", submitDeal.getDealIdx()));
    DealDomain.DealSubmitted event = DealDomain.DealSubmitted.newBuilder()
            .setDealIdx(currentState.getDealIdx())
            .setModifiedTimestamp(Instant.now().toString())
            .setStatus(submitDeal.getStatus())
            .build();
    return effects().emitEvent(event).thenReply(newState -> Empty.getDefaultInstance());
  }

  @Override
  public Effect<DealApi.DealStatus> getDeal(DealDomain.DealState currentState, DealApi.GetDealRequest getDealRequest) {
    if (currentState.getDealIdx().equals("")) {
      return effects().error("Deal " + getDealRequest.getDealIdx() + " has not been created.");
    } else {
      return effects().reply(convertToApi(currentState));
    }
  }

  @Override
  public DealDomain.DealState dealSubmitted(DealDomain.DealState currentState, DealDomain.DealSubmitted dealSubmitted) {
    LOG.info(String.format("Deal submitted event with id %s", dealSubmitted.getDealIdx()));
    return DealDomain.DealState.newBuilder()
            .setDealIdx(currentState.getDealIdx())
            .setCreatedTimestamp(currentState.getCreatedTimestamp())
            .setModifiedTimestamp(dealSubmitted.getModifiedTimestamp())
            .setLifecycleStatus(currentState.getLifecycleStatus())
            .setBrand(currentState.getBrand())
            .setChangedBy(currentState.getChangedBy())
            .setStatus(dealSubmitted.getStatus())
            .build();
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

}
