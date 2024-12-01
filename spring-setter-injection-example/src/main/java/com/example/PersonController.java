package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonController {
    private final UserService userService;

    @Autowired
    public PersonController(UserService userService) {
        System.out.println("构造方法注入");
        this.userService = userService;
    }


    public void Personmethod() {
        userService.performUserOperation();
    }

}
