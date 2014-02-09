
package com.analemma.context_menu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.context_menu.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	public void init(VaadinRequest request) {

		TextArea area = new ContextMenuTextArea();
		area.setWidth(200, Unit.PIXELS);
		area.setHeight(100, Unit.PIXELS);
		setContent(area);
	}
}
