package com.analemma.message_menu_bar;

import javax.servlet.annotation.WebServlet;

import org.vaadin.artur.icepush.ICEPushServlet;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

// TODO: Osposobiti ovaj projekt i napraviti pravi server side push
@Theme("mytheme")
@SuppressWarnings("serial")
@Push
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.message_menu_bar.AppWidgetSet")
  public static class Servlet extends ICEPushServlet {
  }

  @Override
  protected void init(final VaadinRequest request) {

    setContent(new MessageMenuBar());
  }

}
