package com.analemma.vaadin_building_core;

import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class PageLayout extends VerticalLayout {

  private static final long serialVersionUID = -3066825467209897401L;

  private final HeaderLayout headerLayout;
  private final BodyLayout bodyLayout;
  private final FooterLayout footerLayout;

  public PageLayout() {
    setMargin(true);

    headerLayout = new HeaderLayout();
    addComponent(headerLayout);

    bodyLayout = new BodyLayout();
    addComponent(bodyLayout);

    footerLayout = new FooterLayout();
    addComponent(footerLayout);
  }

  public HeaderLayout getHeaderLayout() {
    return headerLayout;
  }

  public BodyLayout getBodyLayout() {
    return bodyLayout;
  }

  public FooterLayout getFooterLayout() {
    return footerLayout;
  }
}
