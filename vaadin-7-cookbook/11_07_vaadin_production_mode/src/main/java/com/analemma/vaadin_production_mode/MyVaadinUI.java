package com.analemma.vaadin_production_mode;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = Settings.productionMode, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_production_mode.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(final VaadinRequest request) {

    final VaadinService service = request.getService();
    final DeploymentConfiguration deploymentConfiguration = service.getDeploymentConfiguration();
    final boolean productionMode = deploymentConfiguration.isProductionMode();
    if (productionMode) {
      final ProductionErrorHandler errorHandler = new ProductionErrorHandler();
      setErrorHandler(errorHandler);
    }

    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    final Button button = new Button("Throw an error please");
    button.addClickListener(new Button.ClickListener() {
      @Override
      public void buttonClick(final ClickEvent event) {
        layout.addComponent(new Label("Click and bang!"));
        throw new RuntimeException(
            "I am the runtime exception and I shouldn't be shown to the clients.");
      }
    });

    layout.addComponent(button);
  }
}
