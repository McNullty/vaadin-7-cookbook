package com.analemma.items;

import com.vaadin.data.Item;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.TextArea;

@SuppressWarnings("serial")
public class CustomTextArea extends TextArea {

  public static final String WIDTH = "width";
  public static final String HEIGHT = "height";

  public CustomTextArea(Item itemDataSource) {
    setItemDataSource(itemDataSource);
  }

  public void setItemDataSource(Item itemDataSource) {
    ObjectProperty<?> widthProperty = (ObjectProperty<?>) itemDataSource.getItemProperty(WIDTH);
    widthProperty.addValueChangeListener(new ValueChangeListener() {
      @Override
      public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
        Integer width = (Integer) event.getProperty().getValue();
        setWidth(width, Unit.PIXELS);
      }
    });

    ObjectProperty<?> heightProperty = (ObjectProperty<?>) itemDataSource.getItemProperty(HEIGHT);
    heightProperty.addValueChangeListener(new ValueChangeListener() {
      @Override
      public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
        Integer height = (Integer) event.getProperty().getValue();
        setHeight(height, Unit.PIXELS);
      }
    });

  }

}
