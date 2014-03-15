package com.analemma.vaadin_spring_login;

import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;

/**
 * @author Ondrej Kvasnovsky
 */
public class LoginForm extends VerticalLayout {

  private static final long serialVersionUID = -7885047617259909495L;

  private TextField txtLogin = new TextField("Login: ");
  private PasswordField txtPassword = new PasswordField("Password: ");
  private Button btnLogin = new Button("Login");

  public LoginForm() {
    addComponent(txtLogin);
    addComponent(txtPassword);
    addComponent(btnLogin);

    LoginFormListener loginFormListener = getLoginFormListener();

    btnLogin.addClickListener(loginFormListener);
  }

  public LoginFormListener getLoginFormListener() {
    MyVaadinUI ui = (MyVaadinUI) UI.getCurrent();
    ApplicationContext context = ui.getApplicationContext();
    return context.getBean(LoginFormListener.class);
  }

  public TextField getTxtLogin() {
    return txtLogin;
  }

  public PasswordField getTxtPassword() {
    return txtPassword;
  }
}
