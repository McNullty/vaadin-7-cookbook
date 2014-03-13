package com.analemma.bind_fields;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class BoundProductForm extends FormLayout {

	private TextField code = new TextField("Product code:");	
	@PropertyId("name")	
	private TextField nameField = new TextField("Product name:");	
	@PropertyId("price")
	private TextField priceField = new TextField("Price (USD):");

	public BoundProductForm() {		
		setSizeUndefined();
		setMargin(true);			

		FieldGroup fieldGroup = new BeanFieldGroup<Product>(Product.class);		
		fieldGroup.setItemDataSource(new BeanItem<Product>(new Product(1, "Tablet", 299.99)));
		fieldGroup.bindMemberFields(this);		
		
		addComponent(code);
		addComponent(nameField);
		addComponent(priceField);	
	}

}
