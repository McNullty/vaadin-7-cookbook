package com.analemma.filtering;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Compare.Greater;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class FilteredTable extends CustomComponent {

  private final BeanItemContainer<Product> container = new BeanItemContainer<>(Product.class);
  private static final Object[] COLUMN_IDS = new Object[] {"id", "name", "price"};
  private static final int[] COLUMN_WIDTHS = {50, 100, 70};
  private static final int COLUMN_SPACE = 13;

  public FilteredTable() {
    final VerticalLayout layout = new VerticalLayout();
    setCompositionRoot(layout);

    final Table table = new Table();
    layout.addComponent(createFilters(table));

    fillContainer(container);
    table.setPageLength(table.size());
    table.setContainerDataSource(container);
    layout.addComponent(table);
  }

  private HorizontalLayout createFilters(final Table table) {
    final HorizontalLayout filtersLayout = new HorizontalLayout();
    int i = 0;
    for (final Object columnID : COLUMN_IDS) {
      final int columnWidth = COLUMN_WIDTHS[i++];
      table.setColumnWidth(columnID, columnWidth);
      final TextField field = new TextField();
      field.setWidth(columnWidth + COLUMN_SPACE, Unit.PIXELS);
      if ("id".equals(columnID)) {
        field.setConverter(Integer.class);
      }
      field.addTextChangeListener(new TextChangeListener() {
        @Override
        public void textChange(final TextChangeEvent event) {
          filterTable(table, columnID, event.getText());
        }
      });

      filtersLayout.addComponent(field);
    }
    return filtersLayout;
  }

  private void filterTable(final Table table, final Object columnID, final String value) {
    container.removeContainerFilters(columnID);

    if ("id".equals(columnID)) {
      try {
        final Filter greater = new Greater(columnID, new Integer(value));
        container.addContainerFilter(greater);
      } catch (final NumberFormatException e) {
        if (!value.isEmpty()) {
          Notification.show("Cannot filter by value: " + value);
        }
      }
    } else {
      container.addContainerFilter(columnID, value, true, false);
    }
  }

  private void fillContainer(final BeanItemContainer<Product> container) {
    int id = 0;
    container.addItem(new Product(id++, "Computer", 599.90));
    container.addItem(new Product(id++, "Phone", 14.5));
    container.addItem(new Product(id++, "Tablet", 99.90));
    container.addItem(new Product(id++, "Mouse", 0.99));
  }

}
