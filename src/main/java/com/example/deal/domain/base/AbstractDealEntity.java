package com.example.deal.domain.base;

import com.example.Components;
import com.example.ComponentsImpl;
import com.example.deal.api.DealApi;
import com.example.deal.domain.DealDomain;
import com.google.protobuf.Empty;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public abstract class AbstractDealEntity extends EventSourcedEntity<DealDomain.DealState> {

  protected final Components components() {
    return new ComponentsImpl(commandContext());
  }

  public abstract Effect<Empty> createDeal(DealDomain.DealState currentState, DealApi.DealRequest dealRequest);

  public abstract Effect<Empty> pay(DealDomain.DealState currentState, DealApi.PayDeal payDeal);

  public abstract Effect<Empty> submit(DealDomain.DealState currentState, DealApi.SubmitDeal submitDeal);

  public abstract Effect<DealApi.DealStatus> getDeal(DealDomain.DealState currentState, DealApi.GetDealRequest getDealRequest);

  public abstract DealDomain.DealState dealSubmitted(DealDomain.DealState currentState, DealDomain.DealSubmitted dealSubmitted);

  public abstract DealDomain.DealState dealPaid(DealDomain.DealState currentState, DealDomain.DealPaid dealPaid);

  public abstract DealDomain.DealState dealFulfilled(DealDomain.DealState currentState, DealDomain.DealFulfilled dealFulfilled);

  public abstract DealDomain.DealState dealCancelled(DealDomain.DealState currentState, DealDomain.DealCancelled dealCancelled);

}