package com.analemma.vaadin_testbench;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_testbench.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  HorizontalLayout layout = new HorizontalLayout();
  TextField txtNr1 = new TextField("Number:");
  ComboBox cmbOperand = new ComboBox("Operand:");
  TextField txtNr2 = new TextField("Number:");
  TextField txtResult = new TextField("Result:");
  Button btnCalculate = new Button("Calculate");

  @Override
  protected void init(final VaadinRequest request) {
    layout.setMargin(true);
    layout.setSpacing(true);
    setContent(layout);

    txtNr1.setId("txtNr1");
    txtNr1.setImmediate(true);
    // txtNr1.setValue(""); // 11247
    layout.addComponent(txtNr1);

    cmbOperand.setId("cmbOperand");
    cmbOperand.addItem("+");
    cmbOperand.addItem("-");
    cmbOperand.select("+");
    cmbOperand.setNullSelectionAllowed(false);
    layout.addComponent(cmbOperand);

    txtNr2.setId("txtNr2");
    txtNr2.setImmediate(true);
    // txtNr2.setValue(""); // 112630
    layout.addComponent(txtNr2);

    txtResult.setId("txtResult");
    // txtResult.setValue("");
    txtResult.setImmediate(true);
    layout.addComponent(txtResult);
    layout.setComponentAlignment(txtResult, Alignment.BOTTOM_RIGHT);

    btnCalculate.setId("btnCalculate");
    btnCalculate.setImmediate(true);
    btnCalculate.addClickListener(new Button.ClickListener() {
      @Override
      public void buttonClick(final ClickEvent event) {
        System.out.println("User clicked!");

        final String nr1 = txtNr1.getValue();
        final String operand = cmbOperand.getValue().toString();
        final String nr2 = txtNr2.getValue();

        Integer result = 0;

        if ("".equals(nr1) || "".equals(nr2)) {
          // warn user he has inserted wrong input
          System.out.println("Values: " + nr1 + nr2);
        } else {
          final Integer i1 = Integer.valueOf(nr1);
          final Integer i2 = Integer.valueOf(nr2);
          if ("+".equals(operand)) {
            result = i1 + i2;
          } else if ("-".equals(operand)) {
            result = i1 - i2;
          }
        }
        txtResult.setValue(result.toString());
      }
    });
    layout.addComponent(btnCalculate);
    layout.setComponentAlignment(btnCalculate, Alignment.BOTTOM_RIGHT);
  }
}
