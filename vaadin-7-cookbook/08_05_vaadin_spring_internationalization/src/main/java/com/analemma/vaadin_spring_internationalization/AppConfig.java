package com.analemma.vaadin_spring_internationalization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
public class AppConfig {

  @Bean
  public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:com/analemma/vaadin_spring_internationalization/messages");
    return messageSource;
  }
}
