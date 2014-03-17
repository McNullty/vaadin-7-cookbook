package com.analemma.vaadin_building_core;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * @author Ondrej Kvasnovsky
 */
public class HeaderLayout extends HorizontalLayout {

  private static final long serialVersionUID = -33541294263086863L;

  public HeaderLayout() {
    final Label label = new Label("User: John Felety");
    addComponent(label);
  }
}
