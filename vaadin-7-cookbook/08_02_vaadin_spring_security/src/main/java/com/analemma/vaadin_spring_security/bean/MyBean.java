package com.analemma.vaadin_spring_security.bean;

/**
 * @author Ondrej Kvasnovsky
 */
public class MyBean {

  private String authenticated;
  private String notAuthenticated;

  public MyBean(String authenticated, String notAuthenticated) {
    this.authenticated = authenticated;
    this.notAuthenticated = notAuthenticated;
  }

  public String getAuthenticated() {
    return authenticated;
  }

  public String getNotAuthenticated() {
    return notAuthenticated;
  }
}
