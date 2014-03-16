package com.analemma.items;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AdminPage extends TabSheet {

  private PropertysetItem item = new PropertysetItem();

  public AdminPage() {
    item.addItemProperty(CustomTextArea.WIDTH, new ObjectProperty<Integer>(50));
    item.addItemProperty(CustomTextArea.HEIGHT, new ObjectProperty<Integer>(40));

    addTab(createPreview());
    addTab(createAdminEditor());
  }

  private Layout createPreview() {
    VerticalLayout layout = new VerticalLayout();
    layout.setCaption("Preview");
    layout.setSpacing(true);
    layout.setMargin(true);
    layout.setSizeFull();
    CustomTextArea textArea = new CustomTextArea(item);
    layout.addComponent(textArea);
    return layout;
  }

  private Layout createAdminEditor() {
    FormLayout layout = new FormLayout();
    layout.setCaption("Admin page");
    layout.setSpacing(true);
    layout.setMargin(true);

    FieldGroup group = new FieldGroup();
    group.setItemDataSource(item);
    for (Object propertyId : group.getUnboundPropertyIds()) {
      layout.addComponent(group.buildAndBind(propertyId));
    }
    layout.addComponent(createCommitButton(group));
    return layout;
  }

  private Button createCommitButton(final FieldGroup group) {
    Button button = new Button("Commit");
    button.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        try {
          group.commit();
        } catch (CommitException e) {
          Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
        }
      }
    });
    return button;
  }

}
