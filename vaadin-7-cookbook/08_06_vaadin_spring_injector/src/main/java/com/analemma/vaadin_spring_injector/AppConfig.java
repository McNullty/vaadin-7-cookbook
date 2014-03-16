package com.analemma.vaadin_spring_injector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
public class AppConfig {

  @Bean
  public UserService userService() {
    return new UserService();
  }
}
