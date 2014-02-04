
package com.analemma.flot;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.flot.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		FlotChart flot = new FlotChart();
		flot.setWidth("300px");
		flot.setHeight("300px");

		// String options =
		// "{ grid: { backgroundColor: { colors: [\"#fef\", \"#eee\"] } } }";
		String options =
			"{" + "grid:{" + "backgroundColor:{" + "colors:[" + "\"#fef\","
				+ "\"#eee\"" + "]" + "}" + "}" + "}";
		String data =
			"[" + "[" + "[0, 5]," + "[2, 7]," + "[4, 8]," + "[10, 5]" + "]"
				+ "]";

		flot.setData(data);
		flot.setOptions(options);
		layout.addComponent(flot);
	}
}
