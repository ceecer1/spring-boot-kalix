package com.example.deal.domain.base;

import com.example.deal.api.DealApi;
import com.example.deal.domain.DealDomain;
import com.example.deal.domain.DealEntity;
import com.example.fsm.SimpleStateMachineConfiguration;
import com.example.util.DealEvents;
import com.example.util.DealStates;
import com.google.protobuf.Descriptors;
import com.google.protobuf.EmptyProto;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityOptions;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.access.StateMachineAccess;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.function.Function;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * An event sourced entity provider that defines how to register and create the entity for
 * the Protobuf service <code>DealService</code>.
 *
 * Should be used with the <code>register</code> method in {@link kalix.javasdk.Kalix}.
 */
public class DealEntityProvider implements EventSourcedEntityProvider<DealDomain.DealState, DealEntity> {

  private static final Logger LOG = LoggerFactory.getLogger(DealEntityProvider.class);
  private final Function<EventSourcedEntityContext, DealEntity> entityFactory;
  private final EventSourcedEntityOptions options;
  private StateMachineFactory<DealStates, DealEvents> factory;
  private StateMachine machine;
  private ApplicationContext ctx;


  /** Factory method of DealEntityProvider */
  public static DealEntityProvider of(Function<EventSourcedEntityContext, DealEntity> entityFactory) {
    LOG.info("AT DealEntityProvider static of method");
    return new DealEntityProvider(entityFactory, EventSourcedEntityOptions.defaults());
  }

  private DealEntityProvider(
      Function<EventSourcedEntityContext, DealEntity> entityFactory,
      EventSourcedEntityOptions options) {
    this.entityFactory = entityFactory;
    this.options = options;
    ctx = new AnnotationConfigApplicationContext(SimpleStateMachineConfiguration.class);
    factory = ctx.getBean(StateMachineFactory.class);
    LOG.info("#############");
    LOG.info("AT DealEntityProvider constructor, injected entity factory with options");
    LOG.info("#############");
  }

  @Override
  public final EventSourcedEntityOptions options() {
    return options;
  }

  public final DealEntityProvider withOptions(EventSourcedEntityOptions options) {
    return new DealEntityProvider(entityFactory, options);
  }

  @Override
  public final Descriptors.ServiceDescriptor serviceDescriptor() {
    return DealApi.getDescriptor().findServiceByName("DealService");
  }

  @Override
  public final String entityType() {
    return "deals";
  }

  @Override
  public final DealEntityRouter newRouter(EventSourcedEntityContext context) {
    String con = context != null ? context.entityId() : "NULL";
    LOG.info("Context details: " + context.toString());
    LOG.info(String.format("AT DealEntityProvider newRouter, entity id: %s", con));
    machine = factory.getStateMachine(context.entityId());
    machine.start();
//    machine.getStateMachineAccessor().doWithAllRegions( new StateMachineFunction<StateMachineAccess<DealStates, DealEvents>>() {
//
//    });
    return new DealEntityRouter(entityFactory.apply(context));
  }

  @Override
  public final Descriptors.FileDescriptor[] additionalDescriptors() {
    return new Descriptors.FileDescriptor[] {
      DealApi.getDescriptor(),
      DealDomain.getDescriptor(),
      EmptyProto.getDescriptor()
    };
  }
}
