
package com.analemma.counter.client.countedtextfield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.analemma.counter.client.CountedTextField;

@SuppressWarnings("serial")
@Connect(CountedTextField.class)
public class CountedTextFieldConnector extends AbstractComponentConnector {

	public CountedTextFieldConnector() {

		getWidget().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {

				String text = getWidget().getText();
				getWidget().setCount(text.length());
			}
		});
	}

	@Override
	protected Widget createWidget() {

		return GWT.create(CountedTextFieldWidget.class);
	}

	@Override
	public CountedTextFieldWidget getWidget() {

		return (CountedTextFieldWidget) super.getWidget();
	}

	@Override
	public CountedTextFieldState getState() {

		return (CountedTextFieldState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {

		super.onStateChanged(stateChangeEvent);
		final String text = getState().text;
		getWidget().setText(text);
		getWidget().setCount(text.length());
	}

}
