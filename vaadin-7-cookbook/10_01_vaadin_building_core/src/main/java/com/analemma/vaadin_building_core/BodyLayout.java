package com.analemma.vaadin_building_core;

import com.vaadin.ui.HorizontalSplitPanel;

/**
 * @author Ondrej Kvasnovsky
 */
public class BodyLayout extends HorizontalSplitPanel {

  private static final long serialVersionUID = 6231865620041376929L;

  private final NavigationTree navigationTree;
  private final ContentLayout contentLayout;

  public BodyLayout() {
    setHeight("500px");
    setSplitPosition(300, Unit.PIXELS);

    navigationTree = new NavigationTree();
    setFirstComponent(navigationTree);

    contentLayout = new ContentLayout();
    setSecondComponent(contentLayout);
  }

  public ContentLayout getContentLayout() {
    return contentLayout;
  }
}
