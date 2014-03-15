package com.analemma.vaadin_spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.analemma.vaadin_spring_security.bean.MyBean;

/**
 * @author Ondrej Kvasnovsky
 */
@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean("You are authenticated.", "You are NOT authenticated.");
        return myBean;
    }

}
