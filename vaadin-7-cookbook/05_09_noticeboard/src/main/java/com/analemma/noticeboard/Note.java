package com.analemma.noticeboard;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Note implements Serializable {
	
	private int id;
	private int positionX;
	private int positionY;
	private String caption;
	private String text = "";
	private int lockedByUser = -1;	

	public Note(int id) {
		this.id = id;
		caption = "Note " + id;
	}

	public Note(int id, int positionX, int positionY, String text) {
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLockedByUser() {
		return lockedByUser;
	}

	public void setLockedByUser(int lockedByUser) {
		this.lockedByUser = lockedByUser;
	}


}
