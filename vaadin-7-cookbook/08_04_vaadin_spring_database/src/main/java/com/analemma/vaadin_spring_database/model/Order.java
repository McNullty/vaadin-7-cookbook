package com.analemma.vaadin_spring_database.model;

/**
 * @author Ondrej Kvasnovsky
 */
public class Order {

  private Integer id;
  private String label;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
