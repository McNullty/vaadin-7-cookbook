package com.analemma.css_layout;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

@SuppressWarnings("serial")
public class TagCloud extends CssLayout {

    @Override
    protected String getCss(Component c) {
	String css = null;
	if (c instanceof TagLabel) {
	    TagLabel tag = (TagLabel) c;
	    css = "font-size: " + tag.getFontSize() + "px;";
	    css += "line-height: " + tag.getFontSize() + "px;";
	    css += "display: inline-block;";
	    css += "margin: 3px;";
	}
	return css;
    };
}
