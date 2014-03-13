package com.analemma.bean_validation;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class ProductForm extends FormLayout {
  private TextField code = new TextField("Product code:");
  private TextField name = new TextField("Product name:");
  private TextField price = new TextField("Price (USD):");
  private FieldGroup fieldGroup;
  private Product product = new Product(1, "Tablet", 299.99);

  public ProductForm() {
    setSizeUndefined();
    setMargin(true);

    fieldGroup = new BeanFieldGroup<Product>(Product.class);
    fieldGroup.setItemDataSource(new BeanItem<Product>(product));
    fieldGroup.bindMemberFields(this);

    addComponent(code);
    addComponent(name);
    addComponent(price);
    addComponent(createOkButton());
  }

  private Button createOkButton() {
    Button okButton = new Button("OK");
    okButton.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        try {
          fieldGroup.commit();
          Notification.show("Product committed: " + product);
        } catch (CommitException e) {
          Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
        }
      }
    });
    return okButton;
  }

}
