package com.analemma.custom_validation;

import com.vaadin.data.Validator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;

@SuppressWarnings("serial")
public class ChangePasswordForm extends FormLayout {

  private PasswordField newPasswordField = new PasswordField("New password:");
  private PasswordField confirmPasswordField = new PasswordField("Confirm new password:");
  private Button okButton = new Button("OK");
  private static final String CONFIRM_MESSAGE = "Passwords are the same";
  private static final String ERROR_MESSAGE = "Passwords must match";

  public ChangePasswordForm() {
    setSizeUndefined();
    setMargin(true);

    confirmPasswordField.addValidator(new Validator() {
      @Override
      public void validate(Object value) throws InvalidValueException {
        String password = (String) value;
        if (!password.equals(newPasswordField.getValue())) {
          throw new InvalidValueException(ERROR_MESSAGE);
        }
      }
    });

    okButton.addClickListener(new ClickListener() {
      @Override
      public void buttonClick(ClickEvent event) {
        try {
          confirmPasswordField.validate();
          Notification.show(CONFIRM_MESSAGE);
        } catch (Exception e) {
          Notification.show(ERROR_MESSAGE, Type.ERROR_MESSAGE);
        }
      }
    });

    addComponent(newPasswordField);
    addComponent(confirmPasswordField);
    addComponent(okButton);
  }

}
