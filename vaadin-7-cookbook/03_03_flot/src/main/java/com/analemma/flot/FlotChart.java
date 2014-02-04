/**
 *
 */

package com.analemma.flot;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author ondrej
 */
@SuppressWarnings("serial")
@JavaScript({
	"https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js",
	"jquery.flot.js", "flot_connector.js"
})
public class FlotChart extends AbstractJavaScriptComponent {

	@Override
	public FlotChartState getState() {

		return (FlotChartState) super.getState();
	}

	public void setData(String source) {

		JSONArray data;
		try {
			data = new JSONArray(source);
			getState().setData(data);
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void setOptions(String options) {

		try {
			JSONObject root = new JSONObject(options);
			getState().setOptions(root);
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
