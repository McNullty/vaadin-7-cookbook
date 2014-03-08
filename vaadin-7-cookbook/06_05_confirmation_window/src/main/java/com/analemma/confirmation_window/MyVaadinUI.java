package com.analemma.confirmation_window;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.confirmation_window.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  public class PeopleTableListener implements Property.ValueChangeListener {

    private final Table table;

    public PeopleTableListener(Table table) {
      this.table = table;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
      event.getProperty().getValue();
      Object itemId = table.getValue();
      Item item = table.getItem(itemId);
      if (item != null) {
        @SuppressWarnings("unchecked")
        Collection<String> columns = (Collection<String>) item.getItemPropertyIds();
        String column = (String) columns.toArray()[0];
        Property<?> itemProperty = item.getItemProperty(column);
        Object value = itemProperty.getValue();

        ConfirmWindow window =
            new ConfirmWindow("Question", "Do you want to fetch " + value + "'s details?", "Yes",
                "No");
        window.setDecision(new Decision() {
          @Override
          public void yes(ClickEvent event) {
            System.out.println("Yes");
          }

          @Override
          public void no(ClickEvent event) {
            System.out.println("No");
          }
        });
      }
    }
  }

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Table table = new Table("This is my Table");

    table.addContainerProperty("First Name", String.class, null);
    table.addContainerProperty("Last Name", String.class, null);
    table.addContainerProperty("Credit", Integer.class, null);

    table.addItem(new Object[] {"John", "Feleti", 3000}, 1);
    table.addItem(new Object[] {"Jim", "Gerades", 10000}, 2);
    table.addItem(new Object[] {"Elias", "Faid", 800}, 3);

    table.setSelectable(true);
    table.setImmediate(true);

    table.addValueChangeListener(new PeopleTableListener(table));

    layout.addComponent(table);
  }
}
