package com.analemma.ui_collection;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;

@SuppressWarnings("serial")
public class ComponentCollection extends Accordion {
    private String[] sizes = { "16", "32", "64" };
    private String[] icons = { "cancel.png", "calendar.png", "document.png", "email.png", "globe.png", "help.png", "note.png", "ok.png", "trash.png", "user.png" };

    public ComponentCollection() {
	setSizeFull();
	createTabs(sizes);
    }

    private void createTabs(String sizes[]) {
	for (String size : sizes) {
	    CssLayout layout = new CssLayout() {
		@Override
		protected String getCss(Component c) {
		    return "display: inline-block;";
		}
	    };
	    layout.setCaption("Icons " + size + "x" + size);
	    addComponent(layout);
	    for (String icon : icons) {
		Resource imageResource = new ThemeResource("../runo/icons/" + size + "/" + icon);
		Image image = new Image(null, imageResource);
		layout.addComponent(image);
	    }
	}
    }

}