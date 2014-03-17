package com.analemma.converters;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class RomanToIntegerConverter implements Converter<String, Integer> {

  private final Map<Character, Integer> romanChars = new LinkedHashMap<>();
  private final Map<String, Integer> subtractedValues = new LinkedHashMap<>();

  private final Map<String, Integer> romanNumerals = new LinkedHashMap<>();

  public RomanToIntegerConverter() {
    romanChars.put('M', 1000);
    romanChars.put('D', 500);
    romanChars.put('C', 100);
    romanChars.put('L', 50);
    romanChars.put('X', 10);
    romanChars.put('V', 5);
    romanChars.put('I', 1);

    subtractedValues.put("IV", 2);
    subtractedValues.put("IX", 2);
    subtractedValues.put("XL", 20);
    subtractedValues.put("XC", 20);
    subtractedValues.put("CD", 200);
    subtractedValues.put("CM", 200);

    romanNumerals.put("M", 1000);
    romanNumerals.put("CM", 900);
    romanNumerals.put("D", 500);
    romanNumerals.put("CD", 400);
    romanNumerals.put("C", 100);
    romanNumerals.put("XC", 90);
    romanNumerals.put("L", 50);
    romanNumerals.put("XL", 40);
    romanNumerals.put("X", 10);
    romanNumerals.put("IX", 9);
    romanNumerals.put("V", 5);
    romanNumerals.put("IV", 4);
    romanNumerals.put("I", 1);
  }

  @Override
  public Integer convertToModel(String romanInput, final Class<? extends Integer> targetType,
      final Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {
    int intOutput = 0;
    for (int x = 0; x < romanInput.length(); x++) {
      final Integer integer = romanChars.get(romanInput.charAt(x));
      if (integer == null) {
        throw new ConversionException();
      }
      intOutput += integer;
    }

    romanInput = romanInput.toUpperCase();
    for (final String substract : subtractedValues.keySet()) {
      if (romanInput.contains(substract)) {
        intOutput -= subtractedValues.get(substract);
      }
    }

    return intOutput;
  }

  @Override
  public String convertToPresentation(Integer intInput, final Class<? extends String> targetType,
      final Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {
    String romanOutput = "";
    for (final String romanKey : romanNumerals.keySet()) {
      final int romanValue = romanNumerals.get(romanKey);
      while (intInput >= romanValue) {
        intInput -= romanValue;
        romanOutput += romanKey;
      }
    }
    return romanOutput;
  }

  @Override
  public Class<Integer> getModelType() {
    return Integer.class;
  }

  @Override
  public Class<String> getPresentationType() {
    return String.class;
  }



}
