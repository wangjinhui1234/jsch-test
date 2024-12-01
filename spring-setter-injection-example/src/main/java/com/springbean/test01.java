package com.springbean;

import org.springframework.beans.factory.annotation.Autowired;

public class test01 {

    @Autowired
    private User user;

    public void method() {
        System.out.println(user.getAge() + user.getName());
    }
}
