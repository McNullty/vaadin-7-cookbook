package com.analemma.improving_app_startup_time;

import javax.servlet.annotation.WebServlet;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
// import org.vaadin.artur.widgetsetoptimizer.WidgetSetOptimizer;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.improving_app_startup_time.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(final VaadinRequest request) {
    // new WidgetSetOptimizer().extend(this);

    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    final Button button = new Button("Click Me");
    button.addClickListener(new Button.ClickListener() {
      @Override
      public void buttonClick(final ClickEvent event) {
        layout.addComponent(new Label("Thank you for clicking"));
      }
    });
    layout.addComponent(button);
  }
}
