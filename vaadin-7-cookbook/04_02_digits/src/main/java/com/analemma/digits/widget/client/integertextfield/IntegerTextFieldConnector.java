
package com.analemma.digits.widget.client.integertextfield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.analemma.digits.widget.IntegerTextField;

@SuppressWarnings("serial")
@Connect(IntegerTextField.class)
public class IntegerTextFieldConnector extends AbstractComponentConnector {

	public IntegerTextFieldConnector() {

		getWidget().addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {

				if (!Character.isDigit(event.getCharCode())) {
					getWidget().cancelKey();
				}
			}
		});
	}

	@Override
	protected Widget createWidget() {

		return GWT.create(IntegerTextFieldWidget.class);
	}

	@Override
	public IntegerTextFieldWidget getWidget() {

		return (IntegerTextFieldWidget) super.getWidget();
	}

	@Override
	public IntegerTextFieldState getState() {

		return (IntegerTextFieldState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {

		super.onStateChanged(stateChangeEvent);
		final String text = getState().text;
		getWidget().setText(text);
	}

}
