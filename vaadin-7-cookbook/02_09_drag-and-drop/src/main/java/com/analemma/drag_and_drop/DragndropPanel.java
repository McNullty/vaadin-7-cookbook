package com.analemma.drag_and_drop;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.DragAndDropWrapper.WrapperTransferable;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

@SuppressWarnings("serial")
public class DragndropPanel extends HorizontalSplitPanel {

    public DragndropPanel() {
	VerticalSplitPanel leftSplitPanel = new VerticalSplitPanel();
	leftSplitPanel.setSizeFull();
	leftSplitPanel.setFirstComponent(createLayout(new HorizontalLayout()));
	leftSplitPanel.setSecondComponent(createLayout(new VerticalLayout()));

	VerticalSplitPanel rightSplitPanel = new VerticalSplitPanel();
	rightSplitPanel.setSizeFull();
	rightSplitPanel.setFirstComponent(createLayout(new GridLayout(3, 3)));
	rightSplitPanel.setSecondComponent(createLayout(new CssLayout() {
	    @Override
	    protected String getCss(Component c) {
		return "display: inline-block;";
	    }
	}));
	setFirstComponent(leftSplitPanel);
	setSecondComponent(rightSplitPanel);
	setSizeFull();
    }

    private Component createLayout(final AbstractLayout layout) {
	layout.addComponent(createButton("one"));
	layout.addComponent(createButton("two"));
	layout.addComponent(createButton("three"));
	layout.addComponent(createButton("four"));
	DragAndDropWrapper dndLayout = new DragAndDropWrapper(layout);
	dndLayout.setSizeFull();
	dndLayout.setDropHandler(new DropHandler() {
	    @Override
	    public AcceptCriterion getAcceptCriterion() {
		return AcceptAll.get();
	    }

	    @Override
	    public void drop(DragAndDropEvent event) {
		WrapperTransferable t = (WrapperTransferable) event.getTransferable();
		layout.addComponent(t.getSourceComponent());
	    }
	});
	return dndLayout;
    }

    private Component createButton(String name) {
	Button button = new Button(name);
	DragAndDropWrapper buttonWrap = new DragAndDropWrapper(button);
	buttonWrap.setDragStartMode(DragStartMode.COMPONENT);
	buttonWrap.setSizeUndefined();
	return buttonWrap;
    }

}
