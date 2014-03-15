package com.analemma.vaadin_spring_security;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.analemma.vaadin_spring_security.bean.MyBean;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.WrappedHttpSession;
import com.vaadin.server.WrappedSession;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
@PreserveOnRefresh
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_spring_security.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  public void init(VaadinRequest request) {
    WrappedSession session = request.getWrappedSession();
    HttpSession httpSession = ((WrappedHttpSession) session).getHttpSession();
    ServletContext servletContext = httpSession.getServletContext();
    ApplicationContext applicationContext =
        WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

    MyBean bean = applicationContext.getBean(MyBean.class);

    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();

    if (authentication != null && authentication.isAuthenticated()) {
      setContent(new Label(bean.getAuthenticated()));
    } else {
      setContent(new Label(bean.getNotAuthenticated()));
    }
  }
}
