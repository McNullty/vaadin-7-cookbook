package com.analemma.container;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class ProductTable extends Table {

	private BeanItemContainer<Product> products = new BeanItemContainer<Product>(Product.class);
	
	public ProductTable() {		
		fillContainer(products);		
		setContainerDataSource(products);
		setPageLength(size());		
	}
	
	private void fillContainer(Container container) {	
		int id = 0;
		container.addItem(new Product(id++, "Computer", 599.90));
		container.addItem(new Product(id++, "Phone", 14.5));
		container.addItem(new Product(id++, "Tablet", 99.90));
		container.addItem(new Product(id++, "Mouse", 0.99));
	}
}
