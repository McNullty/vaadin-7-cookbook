package com.analemma.message_menu_bar;

import org.vaadin.artur.icepush.ICEPush;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;

@SuppressWarnings("serial")
public class MessageMenuBar extends HorizontalLayout {

	private MenuBar menubar = new MenuBar();
	private MenuBar messageBar = new MenuBar();
	private ICEPush pusher = new ICEPush();
	private MenuBar.MenuItem messageMenu;	
	
	private Command menuCommand = new Command() {
		public void menuSelected(MenuItem selectedItem) {
			Notification.show("Action " + selectedItem.getText());
		}
	};

	public MessageMenuBar() {
		setWidth("100%");
		menubar.setSizeFull();
		fillMenu();

		addComponent(menubar);
		addComponent(messageBar);
		addExtension(pusher);

		new MessageCounter().start();
	}

	private void fillMenu() {
		final MenuBar.MenuItem fileItem = menubar.addItem("File", null);
		final MenuBar.MenuItem newItem = fileItem.addItem("New", null);

		fileItem.addItem("Open file...", menuCommand);
		fileItem.addSeparator();

		newItem.addItem("File", menuCommand);
		newItem.addItem("Folder", menuCommand);
		newItem.addItem("Project...", menuCommand);

		fileItem.addItem("Save", menuCommand);

		final MenuBar.MenuItem edit = menubar.addItem("Edit", null);
		edit.addItem("Cut", menuCommand);
		edit.addItem("Copy", menuCommand);
		edit.addItem("Paste", menuCommand);

		messageMenu = messageBar.addItem("New message: 0", null);
	}

	public class MessageCounter extends Thread {
		
		private int count;
		private long nextTime;
		private static final int TIME_INTERVAL = 5000;

		@Override
		public void run() {			
			int oldCount = count;
			while (true) {		
				updateMessageCount();
				if (oldCount != count) {
					getUI().getSession().getLockInstance().lock();
					try {
						oldCount = count;
						messageMenu.setText("New message:" + count);
						pusher.push();							
					} finally {
						getUI().getSession().getLockInstance().unlock();
					}
				}
			}
		}
		
		private void updateMessageCount() {
			long currentTime = System.currentTimeMillis();
			if (currentTime > nextTime ) {
				count++;
				nextTime = currentTime + TIME_INTERVAL;
			}
		}

	}

}
