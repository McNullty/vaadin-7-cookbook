package com.analemma.vaadin_spring_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.analemma.vaadin_spring_login.LoginFormListener;
import com.analemma.vaadin_spring_login.auth.AuthManager;
import com.analemma.vaadin_spring_login.service.UserService;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
@ComponentScan(basePackages = {"com.analemma.vaadin_spring_login",
    "com.analemma.vaadin_spring_login.auth", "com.analemma.vaadin_spring_login.service"})
public class AppConfig {

  @Bean
  public AuthManager authManager() {
    AuthManager res = new AuthManager();
    return res;
  }

  @Bean
  public UserService userService() {
    UserService res = new UserService();
    return res;
  }

  @Bean
  public LoginFormListener loginFormListener() {
    return new LoginFormListener();
  }
}
