
package com.analemma.joda_date_time;

import javax.servlet.annotation.WebServlet;

import org.joda.time.DateTime;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.analemma.joda_date_time.AppWidgetSet")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		Post post = new Post();
		String label = "I really need that stuff.";
		post.setText(label);
		DateTime crated = DateTime.now();
		post.setCreated(crated);

		BeanItem<Post> postBean = new BeanItem<Post>(post);
		FieldGroup fieldGroup = new FieldGroup(postBean);
		FieldGroupFieldFactory fieldFactory = new JodaFieldFactory();
		fieldGroup.setFieldFactory(fieldFactory);
		FormLayout formLayout = new FormLayout();

		formLayout.addComponent(fieldGroup.buildAndBind("text"));
		formLayout.addComponent(fieldGroup.buildAndBind("created"));

		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		layout.addComponent(formLayout);
	}
}
