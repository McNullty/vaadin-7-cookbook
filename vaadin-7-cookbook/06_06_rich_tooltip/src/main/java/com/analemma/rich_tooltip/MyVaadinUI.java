package com.analemma.rich_tooltip;

import javax.servlet.annotation.WebServlet;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.rich_tooltip.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Label label = new Label("Hello Vaadin user");
    String tooltip =
        "<span style=\"font-size:30px;\">Welcome!</span>"
            + "<img src=\"VAADIN/themes/runo/icons/32/globe.png\"/>" + "<br/>"
            + "Please have a look at the following list of useful tips:" + "<ul>"
            + "<li>Buy stuff.</li>" + "<li>Add fee.</li>" + "<li>Sell stuff.</li>" + "</ul>"
            + "<span style=\"color:green;\">Yes, that is the way we do it!</span>";
    SafeHtml html = SafeHtmlUtils.fromSafeConstant(tooltip);
    label.setDescription(html.asString());
    layout.addComponent(label);
  }
}
