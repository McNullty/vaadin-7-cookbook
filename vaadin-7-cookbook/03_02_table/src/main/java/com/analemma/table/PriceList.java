package com.analemma.table;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PriceList extends CustomComponent {

	private BeanItemContainer<Product> container;

	public PriceList(BeanItemContainer<Product> container) {
		this.container = container;
		Table table = createTable();
		table.setContainerDataSource(container);

		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(createAddProductButton());
		layout.addComponent(table);
		setCompositionRoot(layout);
	}

	private Button createAddProductButton() {
		Button addProductButton = new Button("Add product");
		addProductButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				container.addItem(new Product("", 0));
			}
		});
		return addProductButton;
	}

	private Table createTable() {
		Table table = new Table();
		table.setContainerDataSource(container);
		table.setEditable(true);
		table.addGeneratedColumn("Remove", new Table.ColumnGenerator() {
			
			public Object generateCell(Table source, final Object itemId,
					Object columnId) {
				Button removeButton = new Button("x");
				removeButton.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						container.removeItem(itemId);
					}
				});
				return removeButton;
			}
		});
		return table;
	}

}
