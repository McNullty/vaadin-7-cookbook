/**
 * 
 */
package com.analemma.high_charts;

import com.vaadin.shared.ui.JavaScriptComponentState;

import org.json.JSONObject;

/**
 * @author ondrej
 */
@SuppressWarnings("serial")
public class HighchartsState extends JavaScriptComponentState {

	private JSONObject data;

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
}
