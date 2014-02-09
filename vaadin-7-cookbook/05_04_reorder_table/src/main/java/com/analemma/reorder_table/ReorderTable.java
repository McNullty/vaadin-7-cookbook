
package com.analemma.reorder_table;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.DataBoundTransferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class ReorderTable extends Table {

	private BeanItemContainer<Product> container =
		new BeanItemContainer<Product>(Product.class);

	public ReorderTable() {

		fillTableContainer(container);
		setPageLength(size());
		setContainerDataSource(container);
		setColumnReorderingAllowed(true);
		setDragMode(TableDragMode.ROW);
		setDropHandler(createDropHandler());
	}

	private DropHandler createDropHandler() {

		DropHandler dropHandler = new DropHandler() {

			@Override
			public AcceptCriterion getAcceptCriterion() {

				return AcceptAll.get();
			}

			@Override
			public void drop(DragAndDropEvent event) {

				DataBoundTransferable transferable =
					(DataBoundTransferable) event.getTransferable();
				Product sourceItemId = (Product) transferable.getItemId();

				AbstractSelectTargetDetails dropData =
					(AbstractSelectTargetDetails) event.getTargetDetails();
				Object targetItemId = dropData.getItemIdOver();

				if (sourceItemId == targetItemId) {
					return;
				}

				switch (dropData.getDropLocation()) {
				case BOTTOM:
					container.removeItem(sourceItemId);
					container.addItemAfter(targetItemId, sourceItemId);
					break;
				case MIDDLE:
				case TOP:
					container.removeItem(sourceItemId);
					Object prevItemId = container.prevItemId(targetItemId);
					container.addItemAfter(prevItemId, sourceItemId);
					break;
				}
			}
		};

		return dropHandler;
	}

	private void fillTableContainer(BeanItemContainer<Product> container) {

		int id = 0;
		container.addItem(new Product(id++, "Computer", 599.90));
		container.addItem(new Product(id++, "Mobile phone", 14.5));
		container.addItem(new Product(id++, "Tablet", 99.90));
		container.addItem(new Product(id++, "Mouse", 0.99));
	}

}
