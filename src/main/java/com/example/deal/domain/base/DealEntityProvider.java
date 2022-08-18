package com.example.deal.domain.base;

import com.example.deal.api.DealApi;
import com.example.deal.domain.DealDomain;
import com.example.deal.domain.DealEntity;
import com.google.protobuf.Descriptors;
import com.google.protobuf.EmptyProto;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityOptions;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityProvider;

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

  private final Function<EventSourcedEntityContext, DealEntity> entityFactory;
  private final EventSourcedEntityOptions options;

  /** Factory method of DealEntityProvider */
  public static DealEntityProvider of(Function<EventSourcedEntityContext, DealEntity> entityFactory) {
    return new DealEntityProvider(entityFactory, EventSourcedEntityOptions.defaults());
  }

  private DealEntityProvider(
      Function<EventSourcedEntityContext, DealEntity> entityFactory,
      EventSourcedEntityOptions options) {
    this.entityFactory = entityFactory;
    this.options = options;
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
