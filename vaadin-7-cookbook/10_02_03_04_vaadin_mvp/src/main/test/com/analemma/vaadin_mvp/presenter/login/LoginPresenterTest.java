package com.analemma.vaadin_mvp.presenter.login;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.analemma.vaadin_mvp.model.user.UserService;
import com.analemma.vaadin_mvp.view.login.LoginView;
import com.vaadin.ui.TextField;


public class LoginPresenterTest {

  private LoginView view;
  private UserService service;
  private LoginPresenter presenter;

  @Before
  public void setUp() throws Exception {
    view = mock(LoginView.class);

    service = mock(UserService.class);
    presenter = new LoginPresenter(view, service);
  }

  @Test
  public void isLoginWorking() throws Exception {
    final TextField user = new TextField();
    user.setValue("Jimmy");
    final TextField pass = new TextField();
    pass.setValue("Jimmy123");

    when(view.getTxtUsername()).thenReturn(user);
    when(view.getTxtPassword()).thenReturn(pass);

    presenter.login();

    Mockito.verify(service, times(1)).login("Jimmy", "Jimmy123");
    Mockito.verify(view, times(1)).afterSuccessfulLogin();
  }

  @Test
  public void isLoginAttemptIgnoredForEmptyInputs() throws Exception {
    when(view.getTxtUsername()).thenReturn(new TextField(""));
    when(view.getTxtPassword()).thenReturn(new TextField(""));

    presenter.login();

    Mockito.verify(service, times(0)).login(anyString(), anyString());
    Mockito.verify(view, times(1)).afterFailedLogin();
  }

}
