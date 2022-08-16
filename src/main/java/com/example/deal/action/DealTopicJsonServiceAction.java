package com.example.deal.action;

import com.example.deal.action.base.AbstractDealTopicJsonServiceAction;
import com.example.deal.domain.DealDomain;
import com.google.protobuf.Any;
import kalix.javasdk.action.ActionCreationContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your com/example/deal/action/deal_topic_json_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealTopicJsonServiceAction extends AbstractDealTopicJsonServiceAction {

  public DealTopicJsonServiceAction(ActionCreationContext creationContext) {}

  @Override
  public Effect<Any> dealChangeJsonToTopic(DealDomain.DealState dealState) {
    throw new RuntimeException("The command handler for `dealChangeJsonToTopic` is not implemented, yet");
  }
}
