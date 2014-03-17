package com.analemma.converters;

import com.vaadin.data.util.converter.Converter.ConversionException;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class RomanNumeralPanel extends Panel {

  private static final String INTEGER_LABEL = "Integer value: ";

  public RomanNumeralPanel() {
    final GridLayout layout = new GridLayout(2, 2);
    layout.setMargin(true);
    layout.setSpacing(true);
    setContent(layout);
    setSizeUndefined();
    final Label integerLabel = new Label(INTEGER_LABEL);
    final TextField romanField = new TextField("Roman numeral:");
    romanField.setConverter(new RomanToIntegerConverter());

    final Button convertButton = new Button("convert");
    convertButton.setClickShortcut(KeyCode.ENTER, null);
    convertButton.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(final ClickEvent event) {
        String convertedValue;
        try {
          final Integer value = (Integer) romanField.getConvertedValue();
          convertedValue = value.toString();
        } catch (final ConversionException e) {
          convertedValue = "n/a";
        }
        integerLabel.setValue(INTEGER_LABEL + convertedValue);
      }
    });

    layout.addComponent(romanField);
    layout.addComponent(convertButton);
    layout.addComponent(integerLabel);

    layout.setComponentAlignment(convertButton, Alignment.BOTTOM_LEFT);

  }
}
