package com.analemma.improving_app_startup_time;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.vaadin.server.widgetsetutils.ConnectorBundleLoaderFactory;
import com.vaadin.shared.ui.Connect.LoadStyle;

public class OptimizedConnectorBundleLoaderFactory extends ConnectorBundleLoaderFactory {
  private final Set<String> eagerConnectors = new HashSet<String>();
  {
    eagerConnectors.add(com.vaadin.client.ui.ui.UIConnector.class.getName());
    eagerConnectors.add(com.vaadin.client.ui.orderedlayout.VerticalLayoutConnector.class.getName());
    eagerConnectors.add(com.vaadin.client.ui.button.ButtonConnector.class.getName());
  }

  @Override
  protected LoadStyle getLoadStyle(final JClassType connectorType) {
    if (eagerConnectors.contains(connectorType.getQualifiedBinaryName())) {
      return LoadStyle.EAGER;
    } else {
      // Loads all other connectors immediately after the initial view has
      // been rendered
      return LoadStyle.DEFERRED;
    }
  }
}
