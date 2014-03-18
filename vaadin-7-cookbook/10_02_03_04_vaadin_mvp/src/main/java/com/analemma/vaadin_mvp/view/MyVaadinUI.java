package com.analemma.vaadin_mvp.view;

import javax.servlet.annotation.WebServlet;

import com.analemma.vaadin_mvp.model.tag.TagServiceDummy;
import com.analemma.vaadin_mvp.model.user.UserServiceImpl;
import com.analemma.vaadin_mvp.presenter.login.LoginPresenter;
import com.analemma.vaadin_mvp.presenter.tag.TagPresenter;
import com.analemma.vaadin_mvp.view.login.LoginView;
import com.analemma.vaadin_mvp.view.login.impl.LoginViewImpl;
import com.analemma.vaadin_mvp.view.tag.TagView;
import com.analemma.vaadin_mvp.view.tag.impl.TagViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.vaadin_mvp.view.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(final VaadinRequest request) {
    final Navigator navigator = new Navigator(this, this);

    final TagView view = new TagViewImpl();
    view.init();

    final TagPresenter handler = new TagPresenter(view, new TagServiceDummy());
    view.setHandler(handler);

    view.getNewTagLayout().init();
    view.getTagListLayout().init();

    navigator.addView("tags", view);

    final LoginView loginView = new LoginViewImpl();
    final LoginPresenter loginPresenter = new LoginPresenter(loginView, new UserServiceImpl());
    loginView.setHandler(loginPresenter);
    loginView.init();
    navigator.addView("", loginView);

    setNavigator(navigator);
    navigator.navigateTo("");
  }
}
