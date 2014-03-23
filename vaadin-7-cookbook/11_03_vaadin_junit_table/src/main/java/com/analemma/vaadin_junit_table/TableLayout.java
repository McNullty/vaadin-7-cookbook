package com.analemma.vaadin_junit_table;

import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class TableLayout extends VerticalLayout {

  private static final long serialVersionUID = 4523454336925588018L;
  private final Table table = new Table();
  private UserService userService = new UserService();

  public void init() {
    setMargin(true);

    final BeanItemContainer<User> container = getContainer();
    table.setContainerDataSource(container);

    addComponent(table);
  }

  public Table getTable() {
    return table;
  }

  // container that is connected to the database, we need to avoid the connection to database in
  // unit tests
  BeanItemContainer<User> getContainer() {
    final BeanItemContainer<User> container = new BeanItemContainer<User>(User.class);

    final List<User> all = userService.findAll();
    for (final User user : all) {
      container.addBean(user);
    }
    return container;
  }

  void setUserService(final UserService service) {
    this.userService = service;
  }
}
