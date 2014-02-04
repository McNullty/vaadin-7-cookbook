package com.analemma.vaadin_navigator;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Ondrej Kvasnovsky
 */
@SuppressWarnings("serial")
public class WelcomeView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    public WelcomeView() {
        Label lblWelcome = new Label("Welcome back handsome.");
        addComponent(lblWelcome);

        Button btnOrders = new Button("Open new Orders");
        btnOrders.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI ui = UI.getCurrent();
                Navigator navigator = ui.getNavigator();
                navigator.navigateTo(OrdersView.VIEW_NAME);
            }
        });
        addComponent(btnOrders);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
