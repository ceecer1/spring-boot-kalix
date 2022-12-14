package com.example;

import kalix.javasdk.Context;
import kalix.javasdk.DeferredCall;
import kalix.javasdk.impl.DeferredCallImpl;
import kalix.javasdk.impl.InternalContext;
import kalix.javasdk.impl.MetadataImpl;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for direct instantiation, called by generated code, use Action.components() to access
 */
public final class ComponentsImpl implements Components {

  private final InternalContext context;

  public ComponentsImpl(Context context) {
    this.context = (InternalContext) context;
  }

  private <T> T getGrpcClient(Class<T> serviceClass) {
    return context.getComponentGrpcClient(serviceClass);
  }

  @Override
  public DealTopicJsonServiceActionCalls dealTopicJsonServiceAction() {
    return new DealTopicJsonServiceActionCallsImpl();
  }
  @Override
  public DealEntityCalls dealEntity() {
    return new DealEntityCallsImpl();
  }
  @Override
  public DealViewServiceImplCalls dealViewServiceImpl() {
    return new DealViewServiceImplCallsImpl();
  }

  private final class DealTopicJsonServiceActionCallsImpl implements DealTopicJsonServiceActionCalls {
     @Override
    public DeferredCall<com.example.deal.domain.DealDomain.DealSubmitted, com.google.protobuf.Any> dealChangeJsonToTopic(com.example.deal.domain.DealDomain.DealSubmitted dealSubmitted) {
      return new DeferredCallImpl<>(
        dealSubmitted,
        MetadataImpl.Empty(),
        "com.example.deal.action.DealTopicJsonService",
        "dealChangeJsonToTopic",
        () -> getGrpcClient(com.example.deal.action.DealTopicJsonService.class).dealChangeJsonToTopic(dealSubmitted)
      );
    }
  }
  private final class DealEntityCallsImpl implements DealEntityCalls {
     @Override
    public DeferredCall<com.example.deal.api.DealApi.DealRequest, com.google.protobuf.Empty> createDeal(com.example.deal.api.DealApi.DealRequest dealRequest) {
      return new DeferredCallImpl<>(
        dealRequest,
        MetadataImpl.Empty(),
        "com.example.deal.api.DealService",
        "CreateDeal",
        () -> getGrpcClient(com.example.deal.api.DealService.class).createDeal(dealRequest)
      );
    }
    @Override
    public DeferredCall<com.example.deal.api.DealApi.PayDeal, com.google.protobuf.Empty> pay(com.example.deal.api.DealApi.PayDeal payDeal) {
      return new DeferredCallImpl<>(
        payDeal,
        MetadataImpl.Empty(),
        "com.example.deal.api.DealService",
        "Pay",
        () -> getGrpcClient(com.example.deal.api.DealService.class).pay(payDeal)
      );
    }
    @Override
    public DeferredCall<com.example.deal.api.DealApi.SubmitDeal, com.google.protobuf.Empty> submit(com.example.deal.api.DealApi.SubmitDeal submitDeal) {
      return new DeferredCallImpl<>(
        submitDeal,
        MetadataImpl.Empty(),
        "com.example.deal.api.DealService",
        "Submit",
        () -> getGrpcClient(com.example.deal.api.DealService.class).submit(submitDeal)
      );
    }
    @Override
    public DeferredCall<com.example.deal.api.DealApi.GetDealRequest, com.example.deal.api.DealApi.DealStatus> getDeal(com.example.deal.api.DealApi.GetDealRequest getDealRequest) {
      return new DeferredCallImpl<>(
        getDealRequest,
        MetadataImpl.Empty(),
        "com.example.deal.api.DealService",
        "GetDeal",
        () -> getGrpcClient(com.example.deal.api.DealService.class).getDeal(getDealRequest)
      );
    }
  }
  private final class DealViewServiceImplCallsImpl implements DealViewServiceImplCalls {
     @Override
    public DeferredCall<com.example.deal.view.DealViewApi.GetDealRequest, com.example.deal.view.DealViewApi.DealResponse> getDeal(com.example.deal.view.DealViewApi.GetDealRequest getDealRequest) {
      return new DeferredCallImpl<>(
        getDealRequest,
        MetadataImpl.Empty(),
        "com.example.deal.view.DealViewService",
        "GetDeal",
        () -> getGrpcClient(com.example.deal.view.DealViewService.class).getDeal(getDealRequest)
      );
    }
  }
}
