package com.analemma.vaadin_mocking;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class SystemStatusLayout extends HorizontalLayout {

  private static final long serialVersionUID = 7319773441713810002L;
  private final Label lblSystemStatus;

  public SystemStatusLayout() {
    final String value = SystemStatusService.getValue();
    lblSystemStatus = new Label(value);
    addComponent(lblSystemStatus);
  }

  public Label getLblSystemStatus() {
    return lblSystemStatus;
  }
}
