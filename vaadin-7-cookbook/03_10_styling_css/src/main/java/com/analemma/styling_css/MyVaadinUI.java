
package com.analemma.styling_css;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.styling_css.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		Table table = new Table();
		table.setStyleName("myTable");
		table.addContainerProperty("First name", String.class, null);
		table.addContainerProperty("Second name", String.class, null);
		table.addItem(new Object[] {
			"Tom", "Smith"
		}, 0);
		table.addItem(new Object[] {
			"Bob", "Taylor"
		}, 1);
		table.addItem(new Object[] {
			"Jane", "White"
		}, 2);
		table.addItem(new Object[] {
			"Suzan", "Lee"
		}, 3);
		table.setPageLength(table.size());
		setContent(table);
	}
}
