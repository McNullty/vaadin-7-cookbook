package com.analemma.vaadin_spring_database;

import com.analemma.vaadin_spring_database.dao.OrderDAO;
import com.analemma.vaadin_spring_database.model.Order;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import org.springframework.context.ApplicationContext;

/**
 * @author Ondrej Kvasnovsky
 */
public class AddNewOrderListener implements Button.ClickListener {

  private static final long serialVersionUID = 181277110232416885L;

  @Override
  public void buttonClick(Button.ClickEvent event) {
    OrdersView view = (OrdersView) event.getButton().getParent();

    MyVaadinUI current = (MyVaadinUI) (UI.getCurrent());
    ApplicationContext context = current.getApplicationContext();

    OrderDAO orderDAO = context.getBean(OrderDAO.class);

    TextField txtOrderLabel = view.getTxtOrderLabel();
    String value = txtOrderLabel.getValue();

    Order order = new Order();
    order.setLabel(value);
    orderDAO.save(order);

    current.getNavigator().navigateTo("orders");
  }
}
