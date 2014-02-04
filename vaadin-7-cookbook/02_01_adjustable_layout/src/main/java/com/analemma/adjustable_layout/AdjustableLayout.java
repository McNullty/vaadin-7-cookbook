package com.analemma.adjustable_layout;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalSplitPanel;

@SuppressWarnings("serial")
public class AdjustableLayout extends HorizontalSplitPanel {
    private static final String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " + "Ut mollis vehicula gravida. Pellentesque rutrum nisl a ipsum luctus.";

    public AdjustableLayout() {
	setFirstComponent(createMenu());
	setSecondComponent(createContentPanel());
	setSplitPosition(10, Unit.PERCENTAGE);
	setSizeFull();
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

    private Component createContentPanel() {
	VerticalSplitPanel contentPanel = new VerticalSplitPanel();
	contentPanel.setFirstComponent(createEditorPanel());
	contentPanel.setSecondComponent(createTable());
	contentPanel.setSplitPosition(80, Unit.PERCENTAGE);
	return contentPanel;
    }

    private Component createEditorPanel() {
	SafeHtml safeHtml = SafeHtmlUtils.fromSafeConstant("<b>Help</b> <br />" + LIPSUM);
	HorizontalSplitPanel editorPanel = new HorizontalSplitPanel();
	RichTextArea editor = new RichTextArea();
	editor.setSizeFull();
	editor.setValue(LIPSUM);
	editorPanel.setFirstComponent(editor);
	editorPanel.setSecondComponent(new Label(safeHtml.asString(), ContentMode.HTML));
	editorPanel.setSplitPosition(80, Unit.PERCENTAGE);
	return editorPanel;
    }

    private Table createTable() {
	Table table = new Table();
	table.addContainerProperty("Name", String.class, null);
	table.addContainerProperty("Value", String.class, null);
	table.addItem(new Object[] { "Color", "blue" }, null);
	table.addItem(new Object[] { "Height", "600 px" }, null);
	table.addItem(new Object[] { "Width", "1024 px" }, null);
	table.setSizeFull();
	return table;
    }

}
