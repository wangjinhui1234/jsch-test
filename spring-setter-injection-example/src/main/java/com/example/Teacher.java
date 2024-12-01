package com.example;

public class Teacher {
    public String name;
    public int age;

    private Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Teacher createBean(String name, int age) {
        return new Teacher(name, age);
    }

    public void performAction() {
        System.out.println("UserService is performing action for user: " + name);
    }

}
