package com.analemma.generate_fields;

import java.util.Date;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;

@SuppressWarnings("serial")
public class GeneratedProductForm extends Panel {
  private FieldGroupFieldFactory fieldFactory = new DefaultFieldGroupFieldFactory();

  public GeneratedProductForm() {
    super("Product form");
    setSizeUndefined();

    FormLayout layout = new FormLayout();
    layout.setMargin(true);
    setContent(layout);

    FieldGroup fieldGroup = new BeanFieldGroup<Product>(Product.class);
    fieldGroup.setFieldFactory(new FieldGroupFieldFactory() {
      @SuppressWarnings({"unchecked", "rawtypes"})
      @Override
      public <T extends Field> T createField(Class<?> dataType, Class<T> fieldType) {
        if (Date.class.isAssignableFrom(dataType)) {
          return (T) new DateField();
        }
        return fieldFactory.createField(dataType, fieldType);
      }
    });

    fieldGroup.setItemDataSource(new BeanItem<Product>(new Product(1, "Tablet", 299.99)));
    for (Object propertyId : fieldGroup.getUnboundPropertyIds()) {
      layout.addComponent(fieldGroup.buildAndBind(propertyId));
    }

  }


}
