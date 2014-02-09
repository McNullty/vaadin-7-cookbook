
package com.analemma.lazy_loading;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class ProductTable extends Table {

	private BeanItemContainer<Product> tableContainer =
		new BeanItemContainer<Product>(Product.class);

	public ProductTable() {

		fillTableContainer(tableContainer, 10000);
		setPageLength(10);
		setCacheRate(4);
		setContainerDataSource(tableContainer);
	}

	private void fillTableContainer(
		BeanItemContainer<Product> container, int count) {

		for (int i = 0; i < count; i++) {
			container.addItem(new Product(i, "Product-" + i, 599));
		}
	}

}
