package com.analemma.bean_validation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
  @NotNull
  private int code;
  @Size(min = 2, max = 10)
  private String name;
  @Min(0)
  private double price;

  public Product(int code, String name, double price) {
    super();
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

  @Override
  public String toString() {
    return "[" + code + ", " + name + ", " + price + "]";
  }

}
