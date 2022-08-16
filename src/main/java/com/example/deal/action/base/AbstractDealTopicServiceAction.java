package com.example.deal.action.base;

import com.example.Components;
import com.example.ComponentsImpl;
import com.example.deal.action.DealTopicApi;
import com.example.deal.domain.DealDomain;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public abstract class AbstractDealTopicServiceAction extends kalix.javasdk.action.Action {

  protected final Components components() {
    return new ComponentsImpl(contextForComponents());
  }

  public abstract Effect<DealTopicApi.DealStateUpdated> dealChangeProtoToTopic(DealDomain.DealState dealState);
}