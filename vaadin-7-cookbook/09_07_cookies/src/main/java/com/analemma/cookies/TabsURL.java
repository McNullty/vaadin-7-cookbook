package com.analemma.cookies;

import java.util.Iterator;

import javax.servlet.http.Cookie;

import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.VaadinServletResponse;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TabsURL extends TabSheet {
  private static final String tabNames[] =
      {"Home", "Contractors", "Customers", "Employees", "Help"};
  private static final String LAST_TAB_COOKIE_NAME = "vaadin_last_tab_name";

  // VAZNO! PATH varijabla mora odgovarati kontekstu aplikacije
  private static final String PATH = "/09_07_cookies";

  public TabsURL() {
    createTabs(tabNames);
    addSelectedTabChangeListener(new SelectedTabChangeListener() {
      @Override
      public void selectedTabChange(final SelectedTabChangeEvent event) {
        final String selectedTabName = event.getTabSheet().getSelectedTab().getCaption();
        UI.getCurrent().getPage().setUriFragment(selectedTabName);
      }
    });
  }

  private void createTabs(final String tabNames[]) {
    for (final String tabName : tabNames) {
      final VerticalLayout layout = new VerticalLayout();
      layout.setCaption(tabName);
      layout.addComponent(new Label("<h1>" + tabName + "</h1>", ContentMode.HTML));
      layout.setHeight(400, Unit.PIXELS);
      addComponent(layout);
    }
  }

  public void selectTab() {
    String fragment = UI.getCurrent().getPage().getUriFragment();
    if (fragment == null) {
      fragment = getLastTabNameFromCookies();
    }
    final Iterator<Component> iterator = this.iterator();
    while (iterator.hasNext()) {
      final Component tab = iterator.next();
      final String name = tab.getCaption().toLowerCase();
      if (fragment.toLowerCase().equals(name)) {
        setSelectedTab(tab);
        setLastTabNameToCookies(name);
        return;
      }
    }
    setSelectedTab(0);
  }

  private void setLastTabNameToCookies(final String tabName) {
    final Cookie lastTabCookie = new Cookie(LAST_TAB_COOKIE_NAME, tabName);
    lastTabCookie.setPath(PATH);
    final VaadinServletResponse response =
        (VaadinServletResponse) VaadinService.getCurrentResponse();
    response.addCookie(lastTabCookie);
  }

  private String getLastTabNameFromCookies() {
    final Cookie[] cookies =
        ((VaadinServletRequest) VaadinService.getCurrentRequest()).getCookies();
    for (final Cookie cookie : cookies) {
      if (LAST_TAB_COOKIE_NAME.equals(cookie.getName())) {
        return cookie.getValue();
      }
    }
    return "";
  }


}
