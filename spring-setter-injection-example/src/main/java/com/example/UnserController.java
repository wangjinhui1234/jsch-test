package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnserController {
    private UserService userService;
    private Teacher teacher;

    @Autowired
    public void setUserService(UserService userService) {
        System.out.println("对象创建了，并且通过setter注入了依赖");
        this.userService = userService;
    }

    public void handleRequest() {
        // 直接调用可能会导致 NullPointerException
        userService.performUserOperation();
    }

    @Autowired
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
