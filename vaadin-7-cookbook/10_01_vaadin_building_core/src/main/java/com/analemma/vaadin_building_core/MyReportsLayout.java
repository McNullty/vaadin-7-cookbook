package com.analemma.vaadin_building_core;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class MyReportsLayout extends VerticalLayout {

  private static final long serialVersionUID = 6970068427985865815L;

  public MyReportsLayout() {
    final Label lbl = new Label("My reports");
    addComponent(lbl);
  }
}
