package com.analemma.vaadin_building_core;

import com.vaadin.ui.Tree;

/**
 * @author Ondrej Kvasnovsky
 */
public class NavigationTree extends Tree {

  private static final long serialVersionUID = -6791428296427196399L;
  public static final String REPORTS_LABEL = "Reports";
  public static final String MY_REPORTS_LABEL = "My reports";

  public NavigationTree() {
    setCaption("Navigation");

    addItem(REPORTS_LABEL);
    setChildrenAllowed(REPORTS_LABEL, true);

    addItem(MY_REPORTS_LABEL);
    setParent(MY_REPORTS_LABEL, REPORTS_LABEL);
    setChildrenAllowed(MY_REPORTS_LABEL, false);

    expandItemsRecursively(REPORTS_LABEL);
    setNullSelectionAllowed(false);

    final NavigationTreeListener listener = new NavigationTreeListener();
    addItemClickListener(listener);
  }
}
