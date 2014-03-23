package com.analemma.vaadin_tdd_junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class LoginLayoutTest {

  private LoginLayout loginLayout;

  @Before
  public void setUp() throws Exception {
    loginLayout = new LoginLayout();
    loginLayout.init();

    UI.setCurrent(new MyVaadinUI());

    loginLayout.setUserService(new UserService() {
      @Override
      public User login(final String username, final String password) {
        return new User();
      }
    });
  }

  @Test
  public void isLoginButtonPresent() {
    final Button btnLogin = loginLayout.getBtnLogin();
    final int index = loginLayout.getComponentIndex(btnLogin);

    final Component component = loginLayout.getComponent(index);
    Assert.assertEquals(btnLogin, component);
  }

  @Test
  public void isLoginWorking() {
    final TextField txtUsername = loginLayout.getTxtUsername();
    txtUsername.setValue("myusername");
    final TextField txtPassword = loginLayout.getTxtPassword();
    txtPassword.setValue("mypassword");
    final Button btnLogin = loginLayout.getBtnLogin();
    btnLogin.click();

    final User user = (User) UI.getCurrent().getData();
    Assert.assertNotNull(user);
  }
}
