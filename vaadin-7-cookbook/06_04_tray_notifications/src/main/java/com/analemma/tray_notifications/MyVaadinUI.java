package com.analemma.tray_notifications;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.tray_notifications.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  public class NotifyListener implements Button.ClickListener {
    @Override
    public void buttonClick(ClickEvent event) {
      Notification.show("Good job!", Notification.Type.TRAY_NOTIFICATION);

      Notification notification =
          new Notification("Well done!", "You have clicked on the button.",
              Notification.Type.TRAY_NOTIFICATION);

      // notification.setDelayMsec(0);
      notification.setPosition(Position.TOP_RIGHT);
      // notification.setStyleName("mynotification");

      notification.show(Page.getCurrent());
    }
  }

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Button btn = new Button("Click me!");
    btn.addClickListener(new NotifyListener());

    layout.addComponent(btn);
  }
}
