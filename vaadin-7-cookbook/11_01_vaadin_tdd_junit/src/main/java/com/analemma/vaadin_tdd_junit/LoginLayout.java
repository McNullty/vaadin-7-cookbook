package com.analemma.vaadin_tdd_junit;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LoginLayout extends VerticalLayout {

  private static final long serialVersionUID = -1386838731581387836L;

  private final Button btnLogin = new Button("Login");
  private final TextField txtUsername = new TextField("Username:");
  private final TextField txtPassword = new TextField("Password:");

  private UserService userService;

  public void init() {
    setMargin(true);
    addComponent(txtUsername);
    addComponent(txtPassword);
    addComponent(btnLogin);
    btnLogin.addClickListener(new Button.ClickListener() {

      private static final long serialVersionUID = -7683219179799507685L;

      @Override
      public void buttonClick(final Button.ClickEvent clickEvent) {
        final String username = txtUsername.getValue();
        final String password = txtPassword.getValue();
        final User user = userService.login(username, password);
        UI.getCurrent().setData(user);
      }
    });
  }

  public Button getBtnLogin() {
    return btnLogin;
  }

  public TextField getTxtUsername() {
    return txtUsername;
  }

  public TextField getTxtPassword() {
    return txtPassword;
  }

  public void setUserService(final UserService userService) {
    this.userService = userService;
  }
}
