package com.analemma.css_layout;

import com.vaadin.ui.Label;

public class TagLabel extends Label {
    private static final long serialVersionUID = -1097210248498760207L;
    private int fontSize;

    public TagLabel(String text, int fontSize) {
	super(text);
	this.fontSize = fontSize;
	setSizeUndefined();
    }

    public int getFontSize() {
	return fontSize;
    }

}