package com.example.deal.view.base;

import com.example.deal.view.DealViewApi;
import com.example.deal.view.DealViewServiceImpl;
import com.google.protobuf.Descriptors;
import kalix.javasdk.view.ViewCreationContext;
import kalix.javasdk.view.ViewOptions;
import kalix.javasdk.view.ViewProvider;

import java.util.function.Function;

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public class DealViewServiceViewProvider implements ViewProvider<DealViewApi.DealViewState, DealViewServiceImpl> {

  private final Function<ViewCreationContext, DealViewServiceImpl> viewFactory;
  private final String viewId;
  private final ViewOptions options;

  /** Factory method of DealViewServiceImpl */
  public static DealViewServiceViewProvider of(
      Function<ViewCreationContext, DealViewServiceImpl> viewFactory) {
    return new DealViewServiceViewProvider(viewFactory, "DealViewService", ViewOptions.defaults());
  }

  private DealViewServiceViewProvider(
      Function<ViewCreationContext, DealViewServiceImpl> viewFactory,
      String viewId,
      ViewOptions options) {
    this.viewFactory = viewFactory;
    this.viewId = viewId;
    this.options = options;
  }

  @Override
  public String viewId() {
    return viewId;
  }

  @Override
  public final ViewOptions options() {
    return options;
  }

  public final DealViewServiceViewProvider withOptions(ViewOptions options) {
    return new DealViewServiceViewProvider(viewFactory, viewId, options);
  }

  /**
   * Use a custom view identifier. By default, the viewId is the same as the proto service name.
   * A different identifier can be needed when making rolling updates with changes to the view definition.
   */
  public DealViewServiceViewProvider withViewId(String viewId) {
    return new DealViewServiceViewProvider(viewFactory, viewId, options);
  }

  @Override
  public final Descriptors.ServiceDescriptor serviceDescriptor() {
    return DealViewApi.getDescriptor().findServiceByName("DealViewService");
  }

  @Override
  public final DealViewServiceViewRouter newRouter(ViewCreationContext context) {
    return new DealViewServiceViewRouter(viewFactory.apply(context));
  }

  @Override
  public final Descriptors.FileDescriptor[] additionalDescriptors() {
    return new Descriptors.FileDescriptor[] {DealViewApi.getDescriptor()};
  }
}

