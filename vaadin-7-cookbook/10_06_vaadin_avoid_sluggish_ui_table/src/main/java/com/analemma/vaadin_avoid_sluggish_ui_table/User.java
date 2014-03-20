package com.analemma.vaadin_avoid_sluggish_ui_table;

/**
 * @author Ondrej Kvasnovsky
 */
public class User {

  private String name;

  public User(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
