package com.analemma.edit_label;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class EditableLabel extends VerticalLayout {
	private Label label = new Label();
	private TextField textField = new TextField();

	public EditableLabel(String value) {
		label.setValue(value);
		label.setSizeUndefined();
		textField.setPropertyDataSource(label);
		addComponent(label);
		addListeners();
	}

	private void addListeners() {	

		addLayoutClickListener(new LayoutClickListener() {			
			@Override
			public void layoutClick(LayoutClickEvent event) {
				if (event.isDoubleClick()
						&& event.getClickedComponent() instanceof Label) {
					removeComponent(label);
					addComponent(textField);
					textField.focus();
				}				
			}
		});

		textField.addBlurListener(new BlurListener() {
			@Override
			public void blur(BlurEvent event) {
				removeComponent(textField);
				addComponent(label);
			}
		});

	}

}
