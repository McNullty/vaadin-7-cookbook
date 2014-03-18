package com.analemma.vaadin_mvp.view.login.impl;

import com.analemma.vaadin_mvp.view.login.LoginView;
import com.analemma.vaadin_mvp.view.login.LoginViewHandler;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LoginViewImpl extends VerticalLayout implements LoginView {

  private static final long serialVersionUID = 5725359388678494023L;

  private LoginViewHandler handler;

  private TextField txtUsername;
  private TextField txtPassword;

  private Button btnLogin;

  @Override
  public void setHandler(final LoginViewHandler handler) {
    this.handler = handler;
  }

  @Override
  public void init() {
    txtUsername = new TextField("Username:");
    addComponent(txtUsername);
    txtPassword = new TextField("Password:");
    addComponent(txtPassword);

    btnLogin = new Button("Login");
    addComponent(btnLogin);
    btnLogin.addClickListener(new Button.ClickListener() {

      private static final long serialVersionUID = 582630689354182376L;

      @Override
      public void buttonClick(final Button.ClickEvent clickEvent) {
        handler.login();
      }
    });
  }

  @Override
  public TextField getTxtUsername() {
    return txtUsername;
  }

  @Override
  public TextField getTxtPassword() {
    return txtPassword;
  }

  @Override
  public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {}

  @Override
  public Button getBtnLogin() {
    return btnLogin;
  }

  @Override
  public void afterSuccessfulLogin() {
    UI.getCurrent().getNavigator().navigateTo("tags");
  }
}
