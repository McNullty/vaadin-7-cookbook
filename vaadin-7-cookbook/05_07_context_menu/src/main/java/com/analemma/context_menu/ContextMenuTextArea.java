package com.analemma.context_menu;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.vaadin.peter.contextmenu.ContextMenu;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItem;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItemClickEvent;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItemClickListener;

import com.vaadin.ui.TextArea;

@SuppressWarnings("serial")
public class ContextMenuTextArea extends TextArea {

	private ContextMenu menu = new ContextMenu();
	private ContextMenuItem insertItem = menu.addItem("Insert");
	private ContextMenuItem cleanItem = menu.addItem("Clean");
	private ContextMenuItem dateItem = insertItem.addItem("Date");
	private ContextMenuItem nameItem = insertItem.addItem("Name");	
	private static final String NAME = "Vaadin";

	public ContextMenuTextArea() {
		addExtension(menu);
		addListeners();
	}
	
	private void addListeners(){
		
		dateItem.addItemClickListener(new ContextMenuItemClickListener() {

			@Override
			public void contextMenuItemClicked(ContextMenuItemClickEvent event) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
				insertText(format.format(new Date()));				
			}
		});
		
		nameItem.addItemClickListener(new ContextMenuItemClickListener() {
			@Override
			public void contextMenuItemClicked(ContextMenuItemClickEvent event) {
				insertText(NAME);
			}
		});		

		cleanItem.addItemClickListener(new ContextMenuItemClickListener() {
			@Override
			public void contextMenuItemClicked(ContextMenuItemClickEvent event) {
				setValue("");
				focus();
			}
		});
	}
	
	private void insertText(String text) {
		int position = getCursorPosition();
		String value = getValue();
		setValue(value.substring(0, position) + text + value.substring(position));
		focus();
	}
	
	

}
