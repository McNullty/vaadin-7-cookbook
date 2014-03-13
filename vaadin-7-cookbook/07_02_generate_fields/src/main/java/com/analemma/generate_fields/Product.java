package com.analemma.generate_fields;

import java.util.Date;

public class Product {

  private int code;
  private String name;
  private double price;
  private Date date = new Date();
  private boolean salable;

  public Product(int code, String name, double price) {
    this.code = code;
    this.name = name;
    this.price = price;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isSalable() {
    return salable;
  }

  public void setSalable(boolean salable) {
    this.salable = salable;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}
