package com.analemma.vaadin_avoid_sluggish_ui_table_paged;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.jensjansson.pagedtable.ControlsLayout;
import com.jensjansson.pagedtable.PagedTable;
import com.jensjansson.pagedtable.example.User;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_avoid_sluggish_ui_table_paged.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(final VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    final PagedTable table = new PagedTable("Paged lazy loaded table");
    table.setWidth("500px");

    final LazyLoadedContainer container = new LazyLoadedContainer(User.class);
    table.setContainerDataSource(container);
    layout.addComponent(table);

    final ControlsLayout controls = table.createControls();
    controls.setWidth("500px");
    layout.addComponent(controls);
  }
}


class LazyLoadedContainer extends BeanContainer {

  private final UserService userService = new UserService();
  private boolean dirty;
  private int lastSize;

  public LazyLoadedContainer(final Class type) {
    super(type);

  }

  @Override
  public int size() {
    if (lastSize == 0 || dirty) {
      lastSize = userService.size();
    }
    return lastSize;
  }

  @Override
  public BeanItem getItem(final Object itemId) {
    return new BeanItem(itemId);
  }

  @Override
  public List getItemIds(final int startIndex, final int numberOfIds) {
    final int endIndex = startIndex + numberOfIds;
    System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex);
    final List list = userService.list(startIndex, endIndex);
    return list;
  }

  public void setDirty(final boolean dirty) {
    this.dirty = dirty;
  }

  public int getLastSize() {
    return lastSize;
  }
}
