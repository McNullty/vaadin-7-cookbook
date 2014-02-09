
package com.analemma.counter.client;

import com.analemma.counter.client.countedtextfield.CountedTextFieldState;

@SuppressWarnings("serial")
public class CountedTextField extends com.vaadin.ui.TextField {

	@Override
	public CountedTextFieldState getState() {

		return (CountedTextFieldState) super.getState();
	}

	@Override
	public String getValue() {

		return getState().text;
	}

	@Override
	public void setValue(String value) {

		getState().text = value;
	}
}
