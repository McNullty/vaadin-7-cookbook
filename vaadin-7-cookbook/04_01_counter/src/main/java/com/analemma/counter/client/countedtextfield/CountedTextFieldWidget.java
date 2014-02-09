
package com.analemma.counter.client.countedtextfield;

import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class CountedTextFieldWidget extends Composite {

	private TextBox textBox = new TextBox();
	private Label countLabel = new Label("0");
	private HorizontalPanel panel = new HorizontalPanel();
	public static final String CLASSNAME = "countedtextfield";

	public CountedTextFieldWidget() {

		initWidget(panel);
		setStyleName(CLASSNAME);
		panel.add(textBox);
		panel.add(countLabel);
	}

	public String getText() {

		return textBox.getText();
	}

	public void setText(String text) {

		textBox.setText(text);
	}

	public void setCount(int count) {

		countLabel.setText("" + count);
	}

	public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {

		return textBox.addKeyUpHandler(handler);
	}

}
