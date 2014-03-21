package com.analemma.vaadin_seo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class HomeView extends VerticalLayout implements View {

  private static final long serialVersionUID = -6403078537720629471L;

  public HomeView() {
    final Label lblHome = new Label("Home page");
    addComponent(lblHome);

    final Button btnProducts = new Button("Go to products page");
    btnProducts.addClickListener(new Button.ClickListener() {
      private static final long serialVersionUID = 5132995083245295991L;

      @Override
      public void buttonClick(final Button.ClickEvent event) {
        MyVaadinUI.getCurrent().getNavigator().navigateTo("products");
      }
    });
    addComponent(btnProducts);

    setMargin(true);
  }

  @Override
  public void enter(final ViewChangeListener.ViewChangeEvent event) {}
}
