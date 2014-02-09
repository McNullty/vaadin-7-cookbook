
package com.analemma.counter;

import javax.servlet.annotation.WebServlet;

import com.analemma.counter.client.CountedTextField;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.counter.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		setContent(new CountedTextField());
	}
}
