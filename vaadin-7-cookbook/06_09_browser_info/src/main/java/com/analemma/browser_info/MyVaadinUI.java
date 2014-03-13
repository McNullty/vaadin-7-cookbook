package com.analemma.browser_info;

import java.util.Date;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

  @WebServlet(value = "/*", asyncSupported = true)
  @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class,
      widgetset = "com.analemma.browser_info.AppWidgetSet")
  public static class Servlet extends VaadinServlet {
  }

  @Override
  protected void init(VaadinRequest request) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    setContent(layout);

    Label label = new Label("Browser details");
    label.addStyleName(Runo.LABEL_H2);
    layout.addComponent(label);

    Page page = Page.getCurrent();

    int browserWindowHeight = page.getBrowserWindowHeight();
    layout.addComponent(new Label("browserWindowHeight: " + browserWindowHeight));

    int browserWindowWidth = page.getBrowserWindowWidth();
    layout.addComponent(new Label("browserWindowWidth: " + browserWindowWidth));

    WebBrowser webBrowser = page.getWebBrowser();

    boolean secureConnection = webBrowser.isSecureConnection();
    layout.addComponent(new Label("secureConnection: " + secureConnection));

    boolean touchDevice = webBrowser.isTouchDevice();
    layout.addComponent(new Label("touchDevice: " + touchDevice));

    boolean ie = webBrowser.isIE();
    boolean firefox = webBrowser.isFirefox();
    boolean safari = webBrowser.isSafari();
    boolean chrome = webBrowser.isChrome();
    boolean chromeFrame = webBrowser.isChromeFrame();
    boolean opera = webBrowser.isOpera();
    boolean macOSX = webBrowser.isMacOSX();
    boolean linux = webBrowser.isLinux();
    boolean windows = webBrowser.isWindows();

    String address = webBrowser.getAddress();
    layout.addComponent(new Label("address: " + address));

    String browserApplication = webBrowser.getBrowserApplication();
    layout.addComponent(new Label("browserApplication: " + browserApplication));

    int browserMajorVersion = webBrowser.getBrowserMajorVersion();
    layout.addComponent(new Label("browserMajorVersion: " + browserMajorVersion));

    int browserMinorVersion = webBrowser.getBrowserMinorVersion();
    layout.addComponent(new Label("browserMinorVersion: " + browserMinorVersion));

    Date currentDate = webBrowser.getCurrentDate();
    layout.addComponent(new Label("currentDate: " + currentDate));

    int dstSavings = webBrowser.getDSTSavings();
    layout.addComponent(new Label("dstSavings: " + dstSavings));

    Locale locale = webBrowser.getLocale();
    layout.addComponent(new Label("locale: " + locale.toString()));

    Integer rawTimezoneOffset = webBrowser.getRawTimezoneOffset();
    layout.addComponent(new Label("rawTimezoneOffset: " + rawTimezoneOffset));

    int screenHeight = webBrowser.getScreenHeight();
    layout.addComponent(new Label("screenHeight: " + screenHeight));

    int screenWidth = webBrowser.getScreenWidth();
    layout.addComponent(new Label("screenWidth: " + screenWidth));

    Integer timezoneOffset = webBrowser.getTimezoneOffset();
    layout.addComponent(new Label("timezoneOffset: " + timezoneOffset));
  }

}
