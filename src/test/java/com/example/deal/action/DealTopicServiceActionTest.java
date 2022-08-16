//package com.example.deal.action;
//
//import akka.stream.javadsl.Source;
//import com.example.deal.action.DealTopicApi;
//import com.example.deal.action.DealTopicServiceAction;
//import com.example.deal.action.DealTopicServiceActionTestKit;
//import com.example.deal.domain.DealDomain;
//import kalix.javasdk.testkit.ActionResult;
//import org.junit.Ignore;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//// This class was initially generated based on the .proto definition by Kalix tooling.
////
//// As long as this file exists it will not be overwritten: you can maintain it yourself,
//// or delete it so it is regenerated as needed.
//
//public class DealTopicServiceActionTest {
//
//  @Test
//  @Ignore("to be implemented")
//  public void exampleTest() {
//    DealTopicServiceActionTestKit service = DealTopicServiceActionTestKit.of(DealTopicServiceAction::new);
//    // // use the testkit to execute a command
//    // SomeCommand command = SomeCommand.newBuilder()...build();
//    // ActionResult<SomeResponse> result = service.someOperation(command);
//    // // verify the reply
//    // SomeReply reply = result.getReply();
//    // assertEquals(expectedReply, reply);
//  }
//
//  @Test
//  @Ignore("to be implemented")
//  public void dealChangeProtoToTopicTest() {
//    DealTopicServiceActionTestKit testKit = DealTopicServiceActionTestKit.of(DealTopicServiceAction::new);
//    // ActionResult<DealTopicApi.DealStateUpdated> result = testKit.dealChangeProtoToTopic(DealDomain.DealState.newBuilder()...build());
//  }
//
//}
