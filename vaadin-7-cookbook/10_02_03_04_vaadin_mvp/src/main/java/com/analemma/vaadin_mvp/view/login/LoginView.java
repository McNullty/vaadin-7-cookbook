package com.analemma.vaadin_mvp.view.login;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;

public interface LoginView extends View {

  void setHandler(LoginViewHandler handler);

  void init();

  TextField getTxtUsername();

  TextField getTxtPassword();

  Button getBtnLogin();

  void afterSuccessfulLogin();

  void afterFailedLogin();
}
