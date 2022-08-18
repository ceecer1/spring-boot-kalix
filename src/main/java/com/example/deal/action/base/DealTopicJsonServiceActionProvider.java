package com.example.deal.action.base;

import com.example.deal.action.DealTopicJsonApi;
import com.example.deal.action.DealTopicJsonServiceAction;
import com.example.deal.domain.DealDomain;
import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import kalix.javasdk.action.ActionCreationContext;
import kalix.javasdk.action.ActionOptions;
import kalix.javasdk.action.ActionProvider;

import java.util.function.Function;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * DealTopicJsonServiceActionProvider that defines how to register and create the action for
 * the Protobuf service <code>DealTopicJsonService</code>.
 *
 * Should be used with the <code>register</code> method in {@link kalix.javasdk.Kalix}.
 */
public class DealTopicJsonServiceActionProvider implements ActionProvider<DealTopicJsonServiceAction> {

  private final Function<ActionCreationContext, DealTopicJsonServiceAction> actionFactory;
  private final ActionOptions options;

  /** Factory method of DealTopicJsonServiceActionProvider */
  public static DealTopicJsonServiceActionProvider of(Function<ActionCreationContext, DealTopicJsonServiceAction> actionFactory) {
    return new DealTopicJsonServiceActionProvider(actionFactory, ActionOptions.defaults());
  }

  private DealTopicJsonServiceActionProvider(Function<ActionCreationContext, DealTopicJsonServiceAction> actionFactory, ActionOptions options) {
    this.actionFactory = actionFactory;
    this.options = options;
  }

  @Override
  public final ActionOptions options() {
    return options;
  }

  public final DealTopicJsonServiceActionProvider withOptions(ActionOptions options) {
    return new DealTopicJsonServiceActionProvider(actionFactory, options);
  }

  @Override
  public final Descriptors.ServiceDescriptor serviceDescriptor() {
    return DealTopicJsonApi.getDescriptor().findServiceByName("DealTopicJsonService");
  }

  @Override
  public final DealTopicJsonServiceActionRouter newRouter(ActionCreationContext context) {
    return new DealTopicJsonServiceActionRouter(actionFactory.apply(context));
  }

  @Override
  public final Descriptors.FileDescriptor[] additionalDescriptors() {
    return new Descriptors.FileDescriptor[] {
      AnyProto.getDescriptor(),
      DealDomain.getDescriptor(),
      DealTopicJsonApi.getDescriptor()
    };
  }

}
