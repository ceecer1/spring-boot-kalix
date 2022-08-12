package com.example.deal.domain;

import com.example.deal.api.DealApi;
import com.google.protobuf.Empty;
import kalix.javasdk.testkit.ValueEntityResult;
import kalix.javasdk.valueentity.ValueEntity;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealEntityTest {

  @Test
  @Ignore("to be implemented")
  public void exampleTest() {
    DealEntityTestKit service = DealEntityTestKit.of(DealEntity::new);
    // // use the testkit to execute a command
    // // of events emitted, or a final updated state:
    // SomeCommand command = SomeCommand.newBuilder()...build();
    // ValueEntityResult<SomeResponse> result = service.someOperation(command);
    // // verify the reply
    // SomeReply reply = result.getReply();
    // assertEquals(expectedReply, reply);
    // // verify the final state after the command
    // assertEquals(expectedState, service.getState());
  }

  @Test
  @Ignore("to be implemented")
  public void createDealTest() {
    DealEntityTestKit service = DealEntityTestKit.of(DealEntity::new);
    // DealRequest command = DealRequest.newBuilder()...build();
    // ValueEntityResult<DealResponse> result = service.createDeal(command);
  }


  @Test
  @Ignore("to be implemented")
  public void getDealTest() {
    DealEntityTestKit service = DealEntityTestKit.of(DealEntity::new);
    // GetDealRequest command = GetDealRequest.newBuilder()...build();
    // ValueEntityResult<DealResponse> result = service.getDeal(command);
  }

}
