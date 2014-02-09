
package com.analemma.digits.widget;

import com.analemma.digits.widget.client.integertextfield.IntegerTextFieldState;

@SuppressWarnings("serial")
public class IntegerTextField extends com.vaadin.ui.TextField {

	@Override
	public IntegerTextFieldState getState() {

		return (IntegerTextFieldState) super.getState();
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
