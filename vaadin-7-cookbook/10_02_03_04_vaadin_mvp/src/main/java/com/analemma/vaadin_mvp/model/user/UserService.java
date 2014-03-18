package com.analemma.vaadin_mvp.model.user;

import com.analemma.vaadin_mvp.model.ServiceException;

public interface UserService {

  User login(String username, String password) throws ServiceException;
}
