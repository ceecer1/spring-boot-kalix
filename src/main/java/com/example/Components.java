package com.example;

import kalix.javasdk.DeferredCall;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for user extension, provided through generated implementation
 */
public interface Components {
  DealTopicServiceActionCalls dealTopicServiceAction();
  DealTopicJsonServiceActionCalls dealTopicJsonServiceAction();
  DealViewServiceImplCalls dealViewServiceImpl();
  DealEntityCalls dealEntity();

  interface DealTopicServiceActionCalls {
    DeferredCall<com.example.deal.domain.DealDomain.DealState, com.example.deal.action.DealTopicApi.DealStateUpdated> dealChangeProtoToTopic(com.example.deal.domain.DealDomain.DealState dealState);
  }
  interface DealTopicJsonServiceActionCalls {
    DeferredCall<com.example.deal.domain.DealDomain.DealState, com.google.protobuf.Any> dealChangeJsonToTopic(com.example.deal.domain.DealDomain.DealState dealState);
  }
  interface DealViewServiceImplCalls {
    DeferredCall<com.example.deal.view.DealViewApi.GetDealRequest, com.example.deal.view.DealViewApi.DealResponse> getDeal(com.example.deal.view.DealViewApi.GetDealRequest getDealRequest);
  }
  interface DealEntityCalls {
    DeferredCall<com.example.deal.api.DealApi.DealRequest, com.example.deal.api.DealApi.DealStatus> createDeal(com.example.deal.api.DealApi.DealRequest dealRequest);

    DeferredCall<com.example.deal.api.DealApi.GetDealRequest, com.example.deal.api.DealApi.DealStatus> getDeal(com.example.deal.api.DealApi.GetDealRequest getDealRequest);
  }
}
