package com.analemma.vaadin_with_spring;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_with_spring.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  private ApplicationContext context;

  @Override
  protected void init(VaadinRequest request) {
    UserService service = getUserService(request);
    User user = service.getUser();

    String name = user.getName();
    Label lblUserName = new Label("Hi " + name + " !");
    VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);
    layout.addComponent(lblUserName);
  }

  private UserService getUserService(VaadinRequest request) {
    WrappedSession session = request.getWrappedSession();
    HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
    ServletContext servletContext = httpSession.getServletContext();
    context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

    return (UserService) context.getBean("userService");
  }
}
