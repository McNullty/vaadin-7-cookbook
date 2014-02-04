package com.analemma.aligning;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AligningDemo extends VerticalLayout {

    public AligningDemo() {
	Button leftButton = new Button("top, left");
	addComponent(leftButton);
	setComponentAlignment(leftButton, Alignment.TOP_LEFT);

	Button centerButton = new Button("middle, center");
	addComponent(centerButton);
	setComponentAlignment(centerButton, Alignment.MIDDLE_CENTER);

	Button rightButton = new Button("bottom, right");
	addComponent(rightButton);
	setComponentAlignment(rightButton, Alignment.BOTTOM_RIGHT);

	setMargin(true);
	setSizeFull();
    }

}
