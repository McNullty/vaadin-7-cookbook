package com.analemma.tab_layout;

import java.util.Iterator;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TabsURL extends TabSheet {
    private static final String tabNames[] = { "Home", "Contractors", "Customers", "Employees", "Help" };

    public TabsURL() {
	createTabs(tabNames);
	addSelectedTabChangeListener(new SelectedTabChangeListener() {
	    @Override
	    public void selectedTabChange(SelectedTabChangeEvent event) {
		String selectedTabName = event.getTabSheet().getSelectedTab().getCaption();
		UI.getCurrent().getPage().setUriFragment(selectedTabName);
	    }
	});
    }

    private void createTabs(String tabNames[]) {
	for (String tabName : tabNames) {
	    VerticalLayout layout = new VerticalLayout();
	    layout.setCaption(tabName);
	    layout.addComponent(new Label("<h1>" + tabName + "</h1>", ContentMode.HTML));
	    layout.setHeight(400, Unit.PIXELS);
	    addComponent(layout);
	}
    }

    public void selectTab() {
	String fragment = UI.getCurrent().getPage().getUriFragment();
	if (fragment == null) {
	    setSelectedTab(0);
	    return;
	}
	Iterator<Component> iterator = getComponentIterator();
	while (iterator.hasNext()) {
	    Component tab = iterator.next();
	    String name = tab.getCaption().toLowerCase();
	    if (fragment.toLowerCase().equals(name)) {
		setSelectedTab(tab);
		return;
	    }
	}
	setSelectedTab(0);
    }

}
