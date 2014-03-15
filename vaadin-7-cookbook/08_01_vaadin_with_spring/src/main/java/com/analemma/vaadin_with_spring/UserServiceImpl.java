package com.analemma.vaadin_with_spring;

/**
 * @author Ondrej Kvasnovsky
 */
public class UserServiceImpl implements UserService {

  @Override
  public User getUser() {
    // TODO: here we could fetch data from e.g. database
    User user = new User();
    user.setName("Adela");
    return user;
  }
}
