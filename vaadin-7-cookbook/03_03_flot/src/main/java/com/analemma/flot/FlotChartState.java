/**
 *
 */

package com.analemma.flot;

import com.vaadin.shared.ui.JavaScriptComponentState;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author ondrej
 */
@SuppressWarnings("serial")
public class FlotChartState extends JavaScriptComponentState {

	private JSONArray data;
	private JSONObject options;

	public JSONArray getData() {

		return data;
	}

	public void setData(JSONArray data) {

		this.data = data;
	}

	public JSONObject getOptions() {

		return options;
	}

	public void setOptions(JSONObject options) {

		this.options = options;
	}

}
