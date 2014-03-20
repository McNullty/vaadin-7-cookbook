package com.analemma.vaadin_avoid_sluggish_ui_table;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_avoid_sluggish_ui_table.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(final VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    final Table table = new Table("Lazy loaded table");
    table.setWidth("200px");

    // table.setCacheRate(1);

    final LazyLoadedContainer container = new LazyLoadedContainer(User.class);
    table.setContainerDataSource(container);
    layout.addComponent(table);
  }
}


@SuppressWarnings("unchecked")
class LazyLoadedContainer extends BeanContainer {

  private static final long serialVersionUID = -6997244405248616063L;
  private final UserService userService = new UserService();

  public LazyLoadedContainer(final Class type) {
    super(type);
  }

  @Override
  public int size() {
    return userService.size();
  }

  @Override
  public BeanItem getItem(final Object itemId) {
    return new BeanItem(itemId);
  }

  @Override
  public List getItemIds(final int startIndex, final int numberOfIds) {
    final int endIndex = startIndex + numberOfIds;
    System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex);
    final List<User> list = userService.list(startIndex, endIndex);
    return list;
  }
}
