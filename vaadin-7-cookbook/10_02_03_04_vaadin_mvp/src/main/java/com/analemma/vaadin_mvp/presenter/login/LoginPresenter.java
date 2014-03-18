package com.analemma.vaadin_mvp.presenter.login;

import com.analemma.vaadin_mvp.model.ServiceException;
import com.analemma.vaadin_mvp.model.user.UserService;
import com.analemma.vaadin_mvp.view.login.LoginView;
import com.analemma.vaadin_mvp.view.login.LoginViewHandler;
import com.vaadin.ui.TextField;

public class LoginPresenter implements LoginViewHandler {

  private final LoginView view;
  private final UserService service;

  public LoginPresenter(final LoginView view, final UserService service) {
    this.view = view;
    this.service = service;
  }

  @Override
  public void login() {
    final TextField txtUsername = view.getTxtUsername();
    final TextField txtPassword = view.getTxtPassword();

    final String username = txtUsername.getValue();
    final String password = txtPassword.getValue();

    if ("".equals(username) || "".equals(username)) {
      view.afterFailedLogin();
    } else {
      try {
        service.login(username, password);

        view.afterSuccessfulLogin();
      } catch (final ServiceException e) {
        view.afterFailedLogin();
      }
    }
  }
}
