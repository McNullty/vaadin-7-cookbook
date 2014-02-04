
package com.analemma.list_select;

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
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.list_select.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		ContactViewer contactViewer =
			new ContactViewer(createContactContainer());
		setContent(contactViewer);
	}

	private BeanItemContainer<Contact> createContactContainer() {

		BeanItemContainer<Contact> contacts =
			new BeanItemContainer<>(Contact.class);
		contacts.addItem(new Contact("Tom", "Smith", "tom.smith@gmail.com"));
		contacts.addItem(new Contact("Bob", "Taylor", "bob.taylor@yahoo.com"));
		contacts.addItem(new Contact("Jane", "White", "jane.white@outlook.com"));
		contacts.addItem(new Contact("Suzan", "Lee", "suzan.lee@aol.com"));
		return contacts;
	}
}
