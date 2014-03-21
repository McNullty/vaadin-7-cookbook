package com.analemma.vaadin_seo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class ProductsView extends VerticalLayout implements View {

  private static final long serialVersionUID = 4257157657168302040L;

  public ProductsView() {
    final Label lblHome = new Label("Products page");
    addComponent(lblHome);

    setMargin(true);
  }

  @Override
  public void enter(final ViewChangeListener.ViewChangeEvent event) {}
}
