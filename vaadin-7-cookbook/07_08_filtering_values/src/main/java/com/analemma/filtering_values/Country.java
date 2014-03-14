package com.analemma.filtering_values;

import com.vaadin.data.util.BeanItemContainer;

public class Country {

  private String name;
  private BeanItemContainer<String> citiesContainer = new BeanItemContainer<>(String.class);

  public Country(String name, String... cities) {
    this.name = name;
    for (String city : cities) {
      citiesContainer.addItem(city);
    }
  }

  public BeanItemContainer<String> getCitiesContainer() {
    return citiesContainer;
  }

  public String getName() {
    return name;
  }

}
