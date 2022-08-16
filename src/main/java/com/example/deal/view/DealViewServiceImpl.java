package com.example.deal.view;

import com.example.deal.domain.DealDomain;
import com.example.deal.view.base.AbstractDealViewServiceView;
import kalix.javasdk.view.View;
import kalix.javasdk.view.ViewContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the View Service described in your com/example/deal/view/deal_view_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealViewServiceImpl extends AbstractDealViewServiceView {

  public DealViewServiceImpl(ViewContext context) {}

  @Override
  public DealViewApi.DealViewState emptyState() {
    return null;
  }

  @Override
  public View.UpdateEffect<DealViewApi.DealViewState> onUpdateState(
    DealViewApi.DealViewState state, DealDomain.DealState dealState) {
      DealViewApi.DealViewState newViewState =
              DealViewApi.DealViewState.newBuilder()
                      .setDealIdx(dealState.getDealIdx())
                      .setCreatedTimestamp(dealState.getCreatedTimestamp())
                      .setModifiedTimestamp(dealState.getModifiedTimestamp())
                      .setLifecycleStatus(dealState.getLifecycleStatus())
                      .setBrand(dealState.getBrand())
                      .setChannel(dealState.getChannel())
                      .build();
      return effects().updateState(newViewState);
  }
}

