package com.analemma.vaadin_spring_injector;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

public class AppUIProvider extends UIProvider {

  private static final long serialVersionUID = 8611115922860901463L;

  @Override
  public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
    return MyVaadinUI.class;
  }

  @Override
  public UI createInstance(UICreateEvent event) {
    UI instance = super.createInstance(event);
    Injector.inject(instance);
    return instance;
  }
}
