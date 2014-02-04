package com.analemma.css_layout;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.css_layout.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    public void init(VaadinRequest request) {
	String names[] = { "HTML", "Java", "Vaadin", "GWT", "CSS", "Javascript" };
	int fontSizes[] = { 12, 20, 32, 24, 17, 19 };

	TagCloud tagCloud = new TagCloud();
	for (int i = 0; i < names.length; i++) {
	    tagCloud.addComponent(new TagLabel(names[i], fontSizes[i]));
	}

	tagCloud.setWidth(150, Unit.PIXELS);
	setContent(tagCloud);
    }

}
