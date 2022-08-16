package com.example.deal.action.base;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.example.deal.action.DealTopicServiceAction;
import com.example.deal.domain.DealDomain;
import kalix.javasdk.action.Action.Effect;
import kalix.javasdk.action.MessageEnvelope;
import kalix.javasdk.impl.action.ActionRouter;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public class DealTopicServiceActionRouter extends ActionRouter<DealTopicServiceAction> {

  public DealTopicServiceActionRouter(DealTopicServiceAction actionBehavior) {
    super(actionBehavior);
  }

  @Override
  public Effect<?> handleUnary(String commandName, MessageEnvelope<Object> message) {
    switch (commandName) {
      case "dealChangeProtoToTopic":
        return action()
                 .dealChangeProtoToTopic((DealDomain.DealState) message.payload());
      default:
        throw new HandlerNotFound(commandName);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public Source<Effect<?>, NotUsed> handleStreamedOut(String commandName, MessageEnvelope<Object> message) {
    switch (commandName) {
      
      default:
        throw new HandlerNotFound(commandName);
    }
  }

  @Override
  public Effect<?> handleStreamedIn(String commandName, Source<MessageEnvelope<Object>, NotUsed> stream) {
    switch (commandName) {
      
      default:
        throw new HandlerNotFound(commandName);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public Source<Effect<?>, NotUsed> handleStreamed(String commandName, Source<MessageEnvelope<Object>, NotUsed> stream) {
    switch (commandName) {
      
      default:
        throw new HandlerNotFound(commandName);
    }
  }
}
