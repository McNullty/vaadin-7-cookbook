package com.analemma.confirmation_window;

import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.*;

/**
 * @author Ondrej Kvasnovsky
 */
public class ConfirmWindow extends Window {

  private static final long serialVersionUID = 6372767307223080747L;
  private Decision decision;
  private Button btnYes = new Button();
  private Button btnNo = new Button();

  private VerticalLayout layout = new VerticalLayout();
  private HorizontalLayout buttonsLayout = new HorizontalLayout();

  public ConfirmWindow(String caption, String question, String yes, String no) {
    setCaption(caption);
    btnYes.setCaption(yes);
    btnYes.focus();
    btnNo.setCaption(no);
    setModal(true);
    center();

    buttonsLayout.addComponent(btnYes);
    buttonsLayout.setComponentAlignment(btnYes, Alignment.MIDDLE_CENTER);
    buttonsLayout.addComponent(btnNo);
    buttonsLayout.setComponentAlignment(btnNo, Alignment.MIDDLE_CENTER);

    layout.addComponent(new Label(question));
    layout.addComponent(buttonsLayout);
    setContent(layout);

    layout.setMargin(true);
    buttonsLayout.setMargin(true);
    buttonsLayout.setWidth("100%");
    setWidth("300px");
    setHeight("160px");
    setResizable(false);

    btnYes.addClickListener(new Button.ClickListener() {
      private static final long serialVersionUID = 6564937889203812426L;

      @Override
      public void buttonClick(Button.ClickEvent event) {
        decision.yes(event);
        close();
      }
    });
    btnNo.addClickListener(new Button.ClickListener() {
      private static final long serialVersionUID = -7813734135168960124L;

      @Override
      public void buttonClick(Button.ClickEvent event) {
        decision.no(event);
        close();
      }
    });
    addShortcutListener(new ShortcutListener("Close", ShortcutAction.KeyCode.ESCAPE, null) {
      private static final long serialVersionUID = -8836205527991903861L;

      @Override
      public void handleAction(Object sender, Object target) {
        close();
      }
    });
    UI.getCurrent().addWindow(this);
  }

  void setDecision(Decision decision) {
    this.decision = decision;
  }
}
