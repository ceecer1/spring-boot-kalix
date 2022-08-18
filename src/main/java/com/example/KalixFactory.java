package com.example;

import com.example.deal.action.DealTopicJsonServiceAction;
import com.example.deal.action.base.DealTopicJsonServiceActionProvider;
import com.example.deal.domain.DealEntity;
import com.example.deal.domain.base.DealEntityProvider;
import com.example.deal.view.DealViewServiceImpl;
import com.example.deal.view.base.DealViewServiceViewProvider;
import kalix.javasdk.Kalix;
import kalix.javasdk.action.ActionCreationContext;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;
import kalix.javasdk.view.ViewCreationContext;

import java.util.function.Function;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public final class KalixFactory {

  public static Kalix withComponents(
      Function<EventSourcedEntityContext, DealEntity> createDealEntity,
      Function<ActionCreationContext, DealTopicJsonServiceAction> createDealTopicJsonServiceAction,
      Function<ViewCreationContext, DealViewServiceImpl> createDealViewServiceImpl) {
    Kalix kalix = new Kalix();
    return kalix
      .register(DealEntityProvider.of(createDealEntity))
      .register(DealTopicJsonServiceActionProvider.of(createDealTopicJsonServiceAction))
      .register(DealViewServiceViewProvider.of(createDealViewServiceImpl));
  }
}
