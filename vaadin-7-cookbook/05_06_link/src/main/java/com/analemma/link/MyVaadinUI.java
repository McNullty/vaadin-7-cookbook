
package com.analemma.link;

import javax.servlet.annotation.WebServlet;

import org.vaadin.activelink.ActiveLink;
import org.vaadin.activelink.ActiveLink.LinkActivatedEvent;
import org.vaadin.activelink.ActiveLink.LinkActivatedListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.link.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	public void init(VaadinRequest request) {

		VerticalLayout layout = new VerticalLayout();

		Button buttonLink = new Button("Vaadin");
		buttonLink.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				getPage().open("http://vaadin.com", "Vaadin");
			}
		});
		buttonLink.setStyleName(Reindeer.BUTTON_LINK);
		layout.addComponent(buttonLink);

		ActiveLink link =
			new ActiveLink("Vaadin", new ExternalResource("http://vaadin.com"));
		link.setTargetName("_blank");
		link.addListener(new LinkActivatedListener() {

			public void linkActivated(LinkActivatedEvent event) {

				Notification.show("Link was opened in a new window.");
			}
		});
		layout.addComponent(link);
		
		setContent(layout);
	}
}
