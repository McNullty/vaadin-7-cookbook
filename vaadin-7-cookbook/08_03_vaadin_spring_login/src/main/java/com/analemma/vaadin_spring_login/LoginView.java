package com.analemma.vaadin_spring_login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
public class LoginView extends VerticalLayout implements View {

  private static final long serialVersionUID = 1006914555274763003L;

  public LoginView() {
    LoginForm loginForm = new LoginForm();
    addComponent(loginForm);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {}
}
