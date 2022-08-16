package com.example.deal.action.base;

import com.example.Components;
import com.example.ComponentsImpl;
import com.example.deal.domain.DealDomain;
import com.google.protobuf.Any;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public abstract class AbstractDealTopicJsonServiceAction extends kalix.javasdk.action.Action {

  protected final Components components() {
    return new ComponentsImpl(contextForComponents());
  }

  public abstract Effect<Any> dealChangeJsonToTopic(DealDomain.DealState dealState);
}