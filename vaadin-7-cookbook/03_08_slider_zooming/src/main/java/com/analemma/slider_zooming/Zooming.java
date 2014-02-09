
package com.analemma.slider_zooming;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Slider;

@SuppressWarnings("serial")
public class Zooming extends HorizontalLayout {

	private static final int DEFAULT_ZOOM = 60;

	public Zooming() {

		setSpacing(true);
		setMargin(true);

		Panel zoomPanel = new Panel();

		final Image image =
			new Image("", new ThemeResource("../runo/icons/64/globe.png"));
		image.setWidth(DEFAULT_ZOOM, Unit.PERCENTAGE);
		zoomPanel.setContent(image);
		zoomPanel.setWidth(300, Unit.PIXELS);
		zoomPanel.setHeight(300, Unit.PIXELS);

		final Slider slider = new Slider();
		slider.setSizeFull();
		slider.setImmediate(true);
		slider.setOrientation(SliderOrientation.VERTICAL);
		slider.setValue((double) DEFAULT_ZOOM);
		slider.addValueChangeListener(new Property.ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {

				double value = slider.getValue();
				image.setWidth((float) value, Unit.PERCENTAGE);
			}
		});

		addComponent(zoomPanel);
		addComponent(slider);
	}

}
