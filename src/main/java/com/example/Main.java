package com.example;

import com.example.deal.action.DealTopicJsonServiceAction;
import com.example.deal.domain.DealEntity;
import com.example.deal.action.DealTopicServiceAction;
import com.example.deal.util.DealEvents;
import com.example.deal.util.DealStates;
import com.example.deal.view.DealViewServiceImpl;
import kalix.javasdk.Kalix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public final class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  public static Kalix createKalix() {
    // The KalixFactory automatically registers any generated Actions, Views or Entities,
    // and is kept up-to-date with any changes in your protobuf definitions.
    // If you prefer, you may remove this and manually register these components in a
    // `new Kalix()` instance.
    return KalixFactory.withComponents(
            DealEntity::new,
            DealTopicJsonServiceAction::new,
            DealTopicServiceAction::new,
            DealViewServiceImpl::new);
  }

  public static void main(String[] args) throws Exception {
    LOG.info("starting the Kalix service");
    createKalix().start();
  }
}
