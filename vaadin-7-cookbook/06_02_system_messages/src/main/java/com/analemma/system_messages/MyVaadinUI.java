package com.analemma.system_messages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.system_messages.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
    class MySessionInitListener implements SessionInitListener {

      private static final long serialVersionUID = 8545183567861571592L;

      public void sessionInit(SessionInitEvent e) throws ServiceException {
        VaadinService service = e.getService();
        MySystemMessagesProvider provider = new MySystemMessagesProvider();
        service.setSystemMessagesProvider(provider);
      }
    }
    
    @Override
    protected void servletInitialized() throws ServletException {
      super.servletInitialized();

      VaadinServletService service = getService();
      MySessionInitListener listener = new MySessionInitListener();
      service.addSessionInitListener(listener);
    }
  }

  @Override
  protected void init(VaadinRequest request) {
      final VerticalLayout layout = new VerticalLayout();
      layout.setMargin(true);
      setContent(layout);

      Button btn = new Button("Click Button");
      btn.addClickListener(new Button.ClickListener() {
          @Override
          public void buttonClick(ClickEvent clickEvent) {
              Label lbl = new Label("Turn off the server and click the button again.");
              layout.addComponent(lbl);
          }
      });
      layout.addComponent(btn);
  }
}
