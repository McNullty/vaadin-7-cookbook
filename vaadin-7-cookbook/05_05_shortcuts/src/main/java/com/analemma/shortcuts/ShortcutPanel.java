package com.analemma.shortcuts;

import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ShortcutPanel extends Panel implements Handler {

	private Window helpWindow = createHelpWindow();
	private final static Action ACTION_HELP = new ShortcutAction("Help", KeyCode.F1, null);

	public ShortcutPanel() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);		
		setContent(layout);
		
		TextArea textArea = new TextArea();
		Button saveButton = new Button("Save");
		saveButton.setClickShortcut(KeyCode.S, ModifierKey.CTRL);
		saveButton.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("Saved");
			}
		});

		setSizeUndefined();
		layout.addComponent(textArea);
		layout.addComponent(saveButton);
		addActionHandler(this);
	}

	@Override
	public Action[] getActions(Object target, Object sender) {
		return new Action[] { ACTION_HELP };
	}

	@Override
	public void handleAction(Action action, Object sender, Object target) {
		if (action == ACTION_HELP) {
			UI.getCurrent().addWindow(helpWindow);			
		}		
	}

	private Window createHelpWindow() {
		Window window = new Window("Help");
		VerticalLayout layout = new VerticalLayout();		
		layout.addComponent(new Label("Save: Ctrl+S"));
		layout.addComponent(new Label("Help: F1"));
		window.setContent(layout);
		window.center();
		return window;
	}

}
