package com.analemma.vaadin_mvp.view.tag.impl;

import com.analemma.vaadin_mvp.view.tag.NewTagLayout;
import com.analemma.vaadin_mvp.view.tag.TagViewHandler;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class NewTagLayoutImpl extends HorizontalLayout implements NewTagLayout {

  private static final long serialVersionUID = -2604843041614359986L;
  private TextField txtTagName;
  TagViewHandler handler;
  private Button btnConfirm;

  @Override
  public void setHandler(final TagViewHandler handler) {
    this.handler = handler;
  }

  @Override
  public void init() {
    setCaption("New tag");
    setSpacing(true);
    setMargin(true);

    txtTagName = new TextField("Tag name:");
    addComponent(txtTagName);

    btnConfirm = new Button("Confirm");
    btnConfirm.addClickListener(new Button.ClickListener() {

      private static final long serialVersionUID = 1078317218177779128L;

      @Override
      public void buttonClick(final Button.ClickEvent clickEvent) {
        handler.addTag();
      }
    });
    addComponent(btnConfirm);
  }

  public Button getBtnConfirm() {
    return btnConfirm;
  }

  @Override
  public TextField getTxtTagName() {
    return txtTagName;
  }

  @Override
  public void afterSuccessfulSave() {
    txtTagName.setValue("");
    txtTagName.focus();
  }
}
