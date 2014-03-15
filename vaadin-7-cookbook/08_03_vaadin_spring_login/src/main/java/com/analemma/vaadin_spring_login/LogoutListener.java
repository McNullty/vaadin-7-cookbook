package com.analemma.vaadin_spring_login;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Ondrej Kvasnovsky
 */
public class LogoutListener implements Button.ClickListener {

  private static final long serialVersionUID = -6582977857460003320L;

  @Override
  public void buttonClick(Button.ClickEvent clickEvent) {
    SecurityContextHolder.clearContext();
    UI.getCurrent().close();
    Navigator navigator = UI.getCurrent().getNavigator();
    navigator.navigateTo("login");
  }
}
