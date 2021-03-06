package com.analemma.vaadin_spring_database;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.analemma.vaadin_spring_database.dao.OrderDAO;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
@PreserveOnRefresh
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_spring_database.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  private ApplicationContext applicationContext;

  @Override
  protected void init(VaadinRequest request) {
    WrappedSession session = request.getWrappedSession();
    HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
    ServletContext servletContext = httpSession.getServletContext();
    applicationContext =
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

    OrderDAO orderDAO = applicationContext.getBean(OrderDAO.class);
    orderDAO.createDbTable();

    Navigator navigator = new Navigator(this, this);

    OrdersView userView = new OrdersView();
    navigator.addView("orders", userView);

    navigator.navigateTo("orders");
    setNavigator(navigator);
  }

  public ApplicationContext getApplicationContext() {
    return applicationContext;
  }
}
