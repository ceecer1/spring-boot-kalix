package com.example.deal.domain.base;

import com.example.deal.api.DealApi;
import com.example.deal.domain.DealDomain;
import com.example.deal.domain.DealEntity;
import com.example.fsm.SimpleStateMachineConfiguration;
import com.example.util.DealEvents;
import com.example.util.DealStates;
import kalix.javasdk.eventsourcedentity.CommandContext;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
import kalix.javasdk.impl.eventsourcedentity.EventSourcedEntityRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * An event sourced entity handler that is the glue between the Protobuf service <code>DealService</code>
 * and the command and event handler methods in the <code>DealEntity</code> class.
 */
public class DealEntityRouter extends EventSourcedEntityRouter<DealDomain.DealState, DealEntity> {

  private static final Logger LOG = LoggerFactory.getLogger(DealEntityRouter.class);

  public DealEntityRouter(DealEntity entity) {
    super(entity);

    LOG.info("#############");
    LOG.info("AT DealEntityRouter constructor, entity injected");
    LOG.info("#############");
  }

  @Override
  public DealDomain.DealState handleEvent(DealDomain.DealState state, Object event) {
    if (event instanceof DealDomain.DealSubmitted) {
      return entity().dealSubmitted(state, (DealDomain.DealSubmitted) event);
    } else if (event instanceof DealDomain.DealPaid) {
      return entity().dealPaid(state, (DealDomain.DealPaid) event);
    } else if (event instanceof DealDomain.DealFulfilled) {
      return entity().dealFulfilled(state, (DealDomain.DealFulfilled) event);
    } else if (event instanceof DealDomain.DealCancelled) {
      return entity().dealCancelled(state, (DealDomain.DealCancelled) event);
    } else {
      throw new EventHandlerNotFound(event.getClass());
    }
  }

  @Override
  public EventSourcedEntity.Effect<?> handleCommand(
      String commandName, DealDomain.DealState state, Object command, CommandContext context) {
    switch (commandName) {

      case "CreateDeal":
        return entity().createDeal(state, (DealApi.DealRequest) command);

      case "Pay":
        return entity().pay(state, (DealApi.PayDeal) command);

      case "Submit":
        return entity().submit(state, (DealApi.SubmitDeal) command);

      case "GetDeal":
        return entity().getDeal(state, (DealApi.GetDealRequest) command);

      default:
        throw new CommandHandlerNotFound(commandName);
    }
  }
}
