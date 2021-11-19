package com.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    MyBean myBean(){
        return new MyBean();
    }
    @Bean
    public BeanMonitor beanMonitor() {
        return new BeanMonitor();
    }

}
