package com.analemma.vaadin_building_core;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author Ondrej Kvasnovsky
 */
public class FooterLayout extends HorizontalLayout {

  private static final long serialVersionUID = 8956209461347283712L;

  public FooterLayout() {
    final Label label = new Label("Created by me.");
    addComponent(label);
  }
}
