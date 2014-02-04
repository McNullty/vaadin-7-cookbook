package com.analemma.mobile_layout;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;

@SuppressWarnings("serial")
public class MobileLayout extends CssLayout {

    private static final String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipisicing elit.";

    public MobileLayout() {
	Label header = new Label("<h1>CSS layout</h1>", ContentMode.HTML);
	addComponent(header);

	addComponent(createMenu());

	Label content = new Label(LIPSUM);
	content.setWidth(70, Unit.PERCENTAGE);
	addComponent(content);

	addComponent(createMenu());
    }

    @Override
    protected String getCss(Component c) {
	return "margin: 5px; vertical-align: top;";
    }

    private Tree createMenu() {
	Tree menu = new Tree();
	for (int i = 1; i < 6; i++) {
	    String item = "item" + i;
	    String childItem = "subitem" + i;
	    menu.addItem(item);
	    menu.addItem(childItem);
	    menu.setParent(childItem, item);
	    menu.setChildrenAllowed(childItem, false);
	}
	return menu;
    }

}
