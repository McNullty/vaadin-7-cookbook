package com.analemma.vaadin_spring_database;

import com.analemma.vaadin_spring_database.model.Order;
import com.analemma.vaadin_spring_database.service.OrderService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
public class OrdersView extends VerticalLayout implements View {

  private static final long serialVersionUID = 3230742723058070308L;

  private TextField txtOrderLabel = new TextField("Order label: ");

  public void enter(ViewChangeListener.ViewChangeEvent event) {
    removeAllComponents();

    addComponent(txtOrderLabel);

    Button btnAddNewOrder = new Button("Add New Order");
    btnAddNewOrder.addClickListener(new AddNewOrderListener());
    addComponent(btnAddNewOrder);

    // render orders
    MyVaadinUI current = (MyVaadinUI) UI.getCurrent();
    ApplicationContext context = current.getApplicationContext();
    OrderService service = context.getBean(OrderService.class);

    List<Order> all = service.findAll();
    for (Order o : all) {
      String label = o.getLabel();
      Label lbl = new Label("Order label: " + label);
      addComponent(lbl);
    }
  }

  public TextField getTxtOrderLabel() {
    return txtOrderLabel;
  }
}
