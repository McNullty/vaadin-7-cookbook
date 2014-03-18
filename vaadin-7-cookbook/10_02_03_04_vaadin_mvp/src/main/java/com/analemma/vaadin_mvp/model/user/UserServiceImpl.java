package com.analemma.vaadin_mvp.model.user;

import com.analemma.vaadin_mvp.model.ServiceException;

public class UserServiceImpl implements UserService {
  @Override
  public User login(final String username, final String password) throws ServiceException {
    return new User(username, password);
  }
}
