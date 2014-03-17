package com.analemma.vaadin_building_core;

import com.vaadin.event.ItemClickEvent;

/**
 * @author Ondrej Kvasnovsky
 */
public class NavigationTreeListener implements ItemClickEvent.ItemClickListener {

  private static final long serialVersionUID = -4043592812396293196L;

  @Override
  public void itemClick(final ItemClickEvent event) {

    final Object value = event.getItemId();
    final MyVaadinUI current = MyVaadinUI.getCurrent();

    // we should do this in a bit more elegant way (not just use labels from the tree)
    // we can add e.g. object structure fetched from database to the tree
    final ContentLayout contentLayout = current.getPageLayout().getBodyLayout().getContentLayout();
    contentLayout.removeAllComponents();

    if (NavigationTree.REPORTS_LABEL.equals(value)) {
      final ReportsLayout layout = new ReportsLayout();
      contentLayout.addComponent(layout);
    } else if (NavigationTree.MY_REPORTS_LABEL.equals(value)) {
      final MyReportsLayout layout = new MyReportsLayout();
      contentLayout.addComponent(layout);
    }
  }
}
