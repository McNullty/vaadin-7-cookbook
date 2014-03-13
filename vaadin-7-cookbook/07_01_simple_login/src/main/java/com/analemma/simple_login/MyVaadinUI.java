package com.analemma.simple_login;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.simple_login.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(VaadinRequest request) {
    VerticalLayout layout = new VerticalLayout();
    setContent(layout);

    LoginFormPanel loginPanel = new LoginFormPanel();
    layout.addComponent(loginPanel);
    layout.setSizeFull();

    layout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
  }
}
