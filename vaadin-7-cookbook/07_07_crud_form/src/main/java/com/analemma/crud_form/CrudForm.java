package com.analemma.crud_form;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class CrudForm extends VerticalLayout {

  private Table table = new Table();
  private BeanItemContainer<Product> tableContainer;
  private FieldGroup fieldGroup;
  private Action actionDelete = new Action("Delete");
  private int code = 1;
  private static final int MAX_PAGE_LENGTH = 15;

  public CrudForm() {
    setSizeUndefined();
    setMargin(true);

    initTable();
    addComponent(createAddButton());
    addComponent(table);
    table.setPageLength(table.size());
  }

  private void initTable() {
    tableContainer = new BeanItemContainer<Product>(Product.class);
    fillTableContainer(tableContainer);
    table.setContainerDataSource(tableContainer);
    table.setSelectable(true);
    table.addItemClickListener(new ItemClickListener() {
      @Override
      public void itemClick(ItemClickEvent event) {
        if (event.isDoubleClick()) {
          openProductWindow(event.getItem(), "Edit product");
        }
      }
    });

    table.addActionHandler(new Handler() {
      @Override
      public void handleAction(Action action, Object sender, Object target) {
        if (actionDelete == action) {
          tableContainer.removeItem(target);
          updateTable();
        }
      }

      @Override
      public Action[] getActions(Object target, Object sender) {
        return new Action[] {actionDelete};
      }
    });
  }

  private Button createAddButton() {
    Button button = new Button("Add product");
    button.addClickListener(new ClickListener() {
      public void buttonClick(ClickEvent event) {
        openProductWindow(new BeanItem<Product>(new Product(code++)), "Add product");
      }
    });
    return button;
  }

  private void openProductWindow(Item beanItem, String caption) {
    Window window = new Window(caption);
    window.setModal(true);

    FormLayout layout = new FormLayout();
    layout.setMargin(true);
    window.setContent(layout);

    fieldGroup = new BeanFieldGroup<Product>(Product.class);
    fieldGroup.setItemDataSource(beanItem);
    for (Object propertyId : fieldGroup.getUnboundPropertyIds()) {
      layout.addComponent(fieldGroup.buildAndBind(propertyId));
    }
    layout.addComponent(createOkButton(window));
    getUI().addWindow(window);
  }

  private Button createOkButton(final Window window) {
    Button okButton = new Button("OK");
    okButton.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        try {
          fieldGroup.commit();
          @SuppressWarnings("unchecked")
          BeanItem<Product> beanItem = (BeanItem<Product>) fieldGroup.getItemDataSource();
          tableContainer.addItem(beanItem.getBean());
          updateTable();
          window.close();
        } catch (CommitException e) {
          Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
        }
      }
    });
    return okButton;
  }

  private void updateTable() {
    if (table.size() > MAX_PAGE_LENGTH) {
      table.setPageLength(MAX_PAGE_LENGTH);
    } else {
      table.setPageLength(table.size());
    }
    table.markAsDirtyRecursive();
  }

  private void fillTableContainer(BeanItemContainer<Product> tableContainer) {
    tableContainer.addItem(new Product(code++, "Computer", 599.90));
    tableContainer.addItem(new Product(code++, "Mobile phone", 14.5));
    tableContainer.addItem(new Product(code++, "Tablet", 99.90));
    tableContainer.addItem(new Product(code++, "Mouse", 0.99));
  }

}
