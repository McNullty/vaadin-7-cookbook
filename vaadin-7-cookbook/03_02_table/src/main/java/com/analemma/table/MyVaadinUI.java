
package com.analemma.table;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.table.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		PriceList priceList = new PriceList(createProductContainer());
		setContent(priceList);
	}

	private BeanItemContainer<Product> createProductContainer() {

		BeanItemContainer<Product> container =
			new BeanItemContainer<Product>(Product.class);
		container.addItem(new Product("Computer", 599.90));
		container.addItem(new Product("Mobile phone", 14.5));
		container.addItem(new Product("Tablet", 99.90));
		container.addItem(new Product("Mouse", 0.99));
		return container;
	}
}
