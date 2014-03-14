package com.analemma.filtering_values;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;

@SuppressWarnings("serial")
public class CountryForm extends FormLayout {

  private BeanItemContainer<Country> countryContainer = new BeanItemContainer<Country>(
      Country.class);
  private ComboBox countryBox = new ComboBox("Country:", countryContainer);
  private ComboBox cityBox = new ComboBox("City:");

  public CountryForm() {
    setSizeUndefined();
    setMargin(true);

    initComboBoxes();
    addComponent(cityBox);
    addComponent(countryBox);
  }

  private void initComboBoxes() {
    fillCountryContainer(countryContainer);

    cityBox.setFilteringMode(FilteringMode.CONTAINS);
    cityBox.setNullSelectionAllowed(false);
    updateCityBox(countryContainer.getIdByIndex(0));

    countryBox.select(countryContainer.getIdByIndex(0));
    countryBox.setImmediate(true);
    countryBox.setNullSelectionAllowed(false);
    countryBox.setItemCaptionPropertyId("name");
    countryBox.addValueChangeListener(new ValueChangeListener() {
      @Override
      public void valueChange(ValueChangeEvent event) {
        updateCityBox((Country) countryBox.getValue());
      }
    });
  }

  private void updateCityBox(Country country) {
    cityBox.setContainerDataSource(country.getCitiesContainer());
    cityBox.select(country.getCitiesContainer().getIdByIndex(0));
  }

  private void fillCountryContainer(BeanItemContainer<Country> container) {
    container.addItem(new Country("England", "London", "Bristol", "Birmingham"));
    container.addItem(new Country("California", "San Francisco", "San Jose", "Mountain View"));
    container.addItem(new Country("Czech republic", "Prague", "Brno", "Ostrava"));
  }

}
