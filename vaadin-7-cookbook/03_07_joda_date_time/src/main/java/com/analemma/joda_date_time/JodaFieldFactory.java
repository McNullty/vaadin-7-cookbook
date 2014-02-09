package com.analemma.joda_date_time;

import org.joda.time.DateTime;

import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;

@SuppressWarnings("serial")
public class JodaFieldFactory extends DefaultFieldGroupFieldFactory {

	@SuppressWarnings({
		"rawtypes", "unchecked"
	})
	@Override
	public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
		T field;
		if (type.isAssignableFrom(DateTime.class)) {
			DateField dateField = new DateField();
			dateField.setConverter(new DateTimeConverter());
			field = (T) dateField;
		} else {
			field = super.createField(type, fieldType);
		}
		return field;
	}
}