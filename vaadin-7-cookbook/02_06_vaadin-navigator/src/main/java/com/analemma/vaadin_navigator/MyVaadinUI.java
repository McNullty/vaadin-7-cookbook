package com.analemma.vaadin_navigator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.vaadin_navigator.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
	Navigator navigator = new Navigator(this, this);

	navigator.addView(WelcomeView.VIEW_NAME, new WelcomeView());
	navigator.addView(OrdersView.VIEW_NAME, OrdersView.class);

	navigator.navigateTo(WelcomeView.VIEW_NAME);
    }

}
