package com.analemma.joda_date_time;

import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;

import com.vaadin.data.util.converter.Converter;

@SuppressWarnings("serial")
public class DateTimeConverter implements Converter<Date, DateTime> {

	@Override
	public Class<DateTime> getModelType() {
		return DateTime.class;
	}

	@Override
	public Class<Date> getPresentationType() {
		return Date.class;
	}

	@Override
	public DateTime convertToModel(
		Date value, Class<? extends DateTime> targetType, Locale locale)
		throws ConversionException {

		return new DateTime(value);
	}

	@Override
	public Date convertToPresentation(
		DateTime value, Class<? extends Date> targetType, Locale locale)
		throws ConversionException {

		Date date = value.toDate();
		return date;
	}
}