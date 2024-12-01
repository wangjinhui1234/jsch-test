package com.springbean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Bean
    public User user() {
        System.out.println("AppConfig 获取 bean");
        return new User("John", 30);
    }


}
