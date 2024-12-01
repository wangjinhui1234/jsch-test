package com.springbean;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        System.out.println("User 构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 静态工厂方法
    public static User createUser(String name, int age) {
        return new User(name, age);
    }

}
