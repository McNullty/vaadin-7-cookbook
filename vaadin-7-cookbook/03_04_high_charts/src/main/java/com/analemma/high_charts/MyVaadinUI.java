
package com.analemma.high_charts;

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
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.high_charts.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		String jsonData =
			"{" + "chart : " + "{renderTo : 'chart',}, " + "series : " + "[ "
				+ "{" + "type : 'pie', " + "data : " + "[ "
				+ "[ 'Im average looking.', 2 ], "
				+ "[ 'Im shy around girls.', 3 ], "
				+ "[ 'Im level 80 Paladin.', 95 ] " + "] " + "} " + "] " + "}";
		Highcharts highchartsPie = new Highcharts();

		highchartsPie.setData(jsonData);
		highchartsPie.setId("chart");
		highchartsPie.setWidth("400px");
		highchartsPie.setHeight("300px");

		layout.addComponent(highchartsPie);
	}
}
