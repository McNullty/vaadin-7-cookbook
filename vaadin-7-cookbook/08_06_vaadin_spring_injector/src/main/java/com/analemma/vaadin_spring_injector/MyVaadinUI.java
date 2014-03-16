package com.analemma.vaadin_spring_injector;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {
  @Autowired
  UserService userService;

  @Override
  protected void init(VaadinRequest request) {
    // Injector.inject(this);
    // VerticalLayout layout = new VerticalLayout();
    // layout.setMargin(true);
    // setContent(layout);

    String name = userService.getUser().getName();
    Label lblUserName = new Label("Hi " + name + " !");
    setContent(lblUserName);
  }
}
