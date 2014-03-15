package com.analemma.vaadin_with_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
public class AppConfig {

  @Bean(name = "userService")
  public UserService helloWorld() {
    return new UserServiceImpl();
  }
}
