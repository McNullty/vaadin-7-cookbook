package com.analemma.vaadin_building_core;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class ReportsLayout extends VerticalLayout {

  private static final long serialVersionUID = 2369663490647673480L;

  public ReportsLayout() {
    final Label lbl = new Label("Reports");
    addComponent(lbl);
  }
}
