package com.example.deal.view.base;

import com.example.deal.domain.DealDomain;
import com.example.deal.view.DealViewApi;
import com.example.deal.view.DealViewServiceImpl;
import kalix.javasdk.impl.view.UpdateHandlerNotFound;
import kalix.javasdk.impl.view.ViewRouter;
import kalix.javasdk.view.View;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public class DealViewServiceViewRouter extends ViewRouter<DealViewApi.DealViewState, DealViewServiceImpl> {

  public DealViewServiceViewRouter(DealViewServiceImpl view) {
    super(view);
  }

  @Override
  public View.UpdateEffect<DealViewApi.DealViewState> handleUpdate(
      String eventName,
      DealViewApi.DealViewState state,
      Object event) {

    switch (eventName) {
      case "OnUpdateState":
        return view().onUpdateState(
            state,
            (DealDomain.DealState) event);

      default:
        throw new UpdateHandlerNotFound(eventName);
    }
  }

}

