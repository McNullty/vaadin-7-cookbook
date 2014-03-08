package com.analemma.validation_messages;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.validation_messages.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(VaadinRequest request) {
      final VerticalLayout layout = new VerticalLayout();
      layout.setMargin(true);
      setContent(layout);

      TextField txt = new TextField("Enter PIN Code");
      txt.addValidator(new PinValidator());
      txt.setImmediate(true);
      layout.addComponent(txt);
  }
}
