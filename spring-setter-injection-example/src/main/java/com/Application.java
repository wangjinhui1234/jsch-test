package com;

import com.example.AppConfig;
import com.example.PersonController;
import com.example.UnserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        //创建上下文
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UnserController userController = context.getBean(UnserController.class);
        PersonController bean = context.getBean(PersonController.class);

        //请求处理
        userController.handleRequest(); //调用方法，实际使用UserService
        bean.Personmethod();


    }
}
