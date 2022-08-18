package com.example;

import kalix.javasdk.DeferredCall;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for user extension, provided through generated implementation
 */
public interface Components {
  DealTopicJsonServiceActionCalls dealTopicJsonServiceAction();
  DealEntityCalls dealEntity();
  DealViewServiceImplCalls dealViewServiceImpl();

  interface DealTopicJsonServiceActionCalls {
    DeferredCall<com.example.deal.domain.DealDomain.DealSubmitted, com.google.protobuf.Any> dealChangeJsonToTopic(com.example.deal.domain.DealDomain.DealSubmitted dealSubmitted);
  }
  interface DealEntityCalls {
    DeferredCall<com.example.deal.api.DealApi.DealRequest, com.google.protobuf.Empty> createDeal(com.example.deal.api.DealApi.DealRequest dealRequest);

    DeferredCall<com.example.deal.api.DealApi.PayDeal, com.google.protobuf.Empty> pay(com.example.deal.api.DealApi.PayDeal payDeal);

    DeferredCall<com.example.deal.api.DealApi.SubmitDeal, com.google.protobuf.Empty> submit(com.example.deal.api.DealApi.SubmitDeal submitDeal);

    DeferredCall<com.example.deal.api.DealApi.GetDealRequest, com.example.deal.api.DealApi.DealStatus> getDeal(com.example.deal.api.DealApi.GetDealRequest getDealRequest);
  }
  interface DealViewServiceImplCalls {
    DeferredCall<com.example.deal.view.DealViewApi.GetDealRequest, com.example.deal.view.DealViewApi.DealResponse> getDeal(com.example.deal.view.DealViewApi.GetDealRequest getDealRequest);
  }
}
