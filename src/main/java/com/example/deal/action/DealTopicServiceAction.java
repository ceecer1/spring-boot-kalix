package com.example.deal.action;

import com.example.deal.action.base.AbstractDealTopicServiceAction;
import com.example.deal.domain.DealDomain;
import kalix.javasdk.action.ActionCreationContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your com/example/deal/action/deal_topic_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealTopicServiceAction extends AbstractDealTopicServiceAction {

  public DealTopicServiceAction(ActionCreationContext creationContext) {}

  @Override
  public Effect<DealTopicApi.DealStateUpdated> dealChangeProtoToTopic(DealDomain.DealState dealState) {
    throw new RuntimeException("The command handler for `dealChangeProtoToTopic` is not implemented, yet");
  }
}
