package com.example.deal.view.base;

import com.example.deal.domain.DealDomain;
import com.example.deal.view.DealViewApi;
import kalix.javasdk.view.View;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public abstract class AbstractDealViewServiceView extends View<DealViewApi.DealViewState> {

  public abstract UpdateEffect<DealViewApi.DealViewState> onDealSubmitted(
    DealViewApi.DealViewState state, DealDomain.DealSubmitted dealSubmitted);
}

