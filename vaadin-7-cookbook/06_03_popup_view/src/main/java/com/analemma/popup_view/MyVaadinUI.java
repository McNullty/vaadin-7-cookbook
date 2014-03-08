package com.analemma.popup_view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.popup_view.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    VerticalLayout login = new VerticalLayout();
    TextField txtUsername = new TextField("Username:");
    login.addComponent(txtUsername);
    TextField txtPassword = new TextField("Password:");
    login.addComponent(txtPassword);
    Button btnLogin = new Button("Login");
    login.addComponent(btnLogin);

    PopupView popup = new PopupView("Click me!", login);
    popup.setHideOnMouseOut(true);
    layout.addComponent(popup);
  }
}
