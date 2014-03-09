package com.analemma.indeterminate_process;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.indeterminate_process.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  class PriceCalculation implements Runnable {

    private long calculated = 0;
    private final ProgressBar indicator;
    private final Label label;

    public PriceCalculation(ProgressBar indicator, Label label) {
      this.indicator = indicator;
      this.label = label;
    }

    public void addResult(int result) {
      calculated += result;
    }

    @Override
    public void run() {
      // TODO: fetch data from DB
      int data = 20000;

      // perform calculation
      for (int i = 0; i < data; i++) {
        for (int j = 0; j < data; j++) {
          int result = i + j;
          addResult(result);
        }
      }

      getSession().getLockInstance().lock();
      try {
        // inform UI about result
        label.setValue("Result is: " + calculated);
        indicator.setVisible(false);
      } finally {
        getSession().getLockInstance().unlock();
      }
    }
  }

  public class StartCalculationListener implements Button.ClickListener {

    private final ProgressBar indicator;
    private final Label label;

    public StartCalculationListener(ProgressBar indicator, Label label) {
      this.indicator = indicator;
      this.label = label;
    }

    @Override
    public void buttonClick(ClickEvent event) {
      indicator.setVisible(true);
      Thread thread = new Thread(new PriceCalculation(indicator, label));
      thread.start();
    }
  }

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    ProgressBar indicator = new ProgressBar();
    UI.getCurrent().setPollInterval(200);
    Label label = new Label();

    Button button = new Button("Start calculation");
    layout.addComponent(button);

    indicator.setIndeterminate(true);
    indicator.setVisible(false);
    layout.addComponent(indicator);

    layout.addComponent(label);

    button.addClickListener(new StartCalculationListener(indicator, label));
  }

}
