package com.example.deal.action.base;

import com.example.deal.action.DealTopicApi;
import com.example.deal.action.DealTopicServiceAction;
import com.example.deal.domain.DealDomain;
import com.google.protobuf.Descriptors;
import kalix.javasdk.action.ActionCreationContext;
import kalix.javasdk.action.ActionOptions;
import kalix.javasdk.action.ActionProvider;

import java.util.function.Function;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * DealTopicServiceActionProvider that defines how to register and create the action for
 * the Protobuf service <code>DealTopicService</code>.
 *
 * Should be used with the <code>register</code> method in {@link kalix.javasdk.Kalix}.
 */
public class DealTopicServiceActionProvider implements ActionProvider<DealTopicServiceAction> {

  private final Function<ActionCreationContext, DealTopicServiceAction> actionFactory;
  private final ActionOptions options;

  /** Factory method of DealTopicServiceActionProvider */
  public static DealTopicServiceActionProvider of(Function<ActionCreationContext, DealTopicServiceAction> actionFactory) {
    return new DealTopicServiceActionProvider(actionFactory, ActionOptions.defaults());
  }

  private DealTopicServiceActionProvider(Function<ActionCreationContext, DealTopicServiceAction> actionFactory, ActionOptions options) {
    this.actionFactory = actionFactory;
    this.options = options;
  }

  @Override
  public final ActionOptions options() {
    return options;
  }

  public final DealTopicServiceActionProvider withOptions(ActionOptions options) {
    return new DealTopicServiceActionProvider(actionFactory, options);
  }

  @Override
  public final Descriptors.ServiceDescriptor serviceDescriptor() {
    return DealTopicApi.getDescriptor().findServiceByName("DealTopicService");
  }

  @Override
  public final DealTopicServiceActionRouter newRouter(ActionCreationContext context) {
    return new DealTopicServiceActionRouter(actionFactory.apply(context));
  }

  @Override
  public final Descriptors.FileDescriptor[] additionalDescriptors() {
    return new Descriptors.FileDescriptor[] {
      DealDomain.getDescriptor(),
      DealTopicApi.getDescriptor()
    };
  }

}
