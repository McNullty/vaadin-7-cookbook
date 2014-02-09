package com.analemma.joda_date_time;

import org.joda.time.DateTime;

public class Post {

	private String text;
	private DateTime created;
	
	public String getText() {
		return text;
	}
	public void setText(String label) {
		this.text = label;
	}
	public DateTime getCreated() {
		return created;
	}
	public void setCreated(DateTime created) {
		this.created = created;
	}
	
	
}
