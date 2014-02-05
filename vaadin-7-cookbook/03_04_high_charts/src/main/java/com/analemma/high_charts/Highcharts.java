/**
 *
 */
package com.analemma.high_charts;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author ondrej
 */
@SuppressWarnings("serial")
@JavaScript({
        "https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js",
        "http://code.highcharts.com/highcharts.js", "highcharts_connector.js" })
public class Highcharts extends AbstractJavaScriptComponent {

    @Override
    public HighchartsState getState() {
        return (HighchartsState) super.getState();
    }

    public void setData(String jsonData) {
        try {
            JSONObject data = new JSONObject(jsonData);
            getState().setData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
