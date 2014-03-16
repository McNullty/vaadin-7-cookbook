package com.analemma.vaadin_spring_internationalization;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author Ondrej Kvasnovsky
 */
public class UserView extends HorizontalLayout {

  private static final long serialVersionUID = -2203412624919626328L;

  public UserView() {
    MyVaadinUI current = (MyVaadinUI) UI.getCurrent();
    ApplicationContext applicationContext = current.getApplicationContext();
    MessageSource messageSource =
        applicationContext.getBean(ReloadableResourceBundleMessageSource.class);

    Locale locale = LocaleContextHolder.getLocale();
    // Locale locale = new Locale("fi", "FI");
    String localizedName = messageSource.getMessage("label.name", null, locale);

    Label lblName = new Label(localizedName);
    addComponent(lblName);
  }

}
