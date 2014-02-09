
package com.analemma.immediately;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ImmediatelyTextArea extends VerticalLayout {

	public ImmediatelyTextArea() {

		TextArea textArea = new TextArea();
		textArea.setImmediate(true);
		textArea.setTextChangeEventMode(TextChangeEventMode.EAGER);

		final Button saveButton = new Button("Saved");
		saveButton.setEnabled(false);

		textArea.addTextChangeListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {

				saveButton.setCaption("Save");
				saveButton.setEnabled(true);
			}
		});

		saveButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				saveButton.setCaption("Saved");
				saveButton.setEnabled(false);
			}
		});

		addComponent(textArea);
		addComponent(saveButton);
	}

}
