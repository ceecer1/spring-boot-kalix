package com.example.deal.action;

import akka.stream.javadsl.Source;
import com.example.deal.action.DealTopicJsonServiceAction;
import com.example.deal.action.DealTopicJsonServiceActionTestKit;
import com.example.deal.domain.DealDomain;
import com.google.protobuf.Any;
import kalix.javasdk.testkit.ActionResult;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealTopicJsonServiceActionTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    DealTopicJsonServiceActionTestKit service = DealTopicJsonServiceActionTestKit.of(DealTopicJsonServiceAction::new);
    // // use the testkit to execute a command
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ActionResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
  }

  @Test
  @Ignore("to be implemented")
  public void dealChangeJsonToTopicTest() {
    DealTopicJsonServiceActionTestKit testKit = DealTopicJsonServiceActionTestKit.of(DealTopicJsonServiceAction::new);
    // ActionResult<Any> result = testKit.dealChangeJsonToTopic(DealDomain.DealState.newBuilder()...build());
  }

}
