package com.springbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class springbeanTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // User bean = annotationConfigApplicationContext.getBean(User.class);
        //打印用户信息
        //System.out.println("name" + bean.getName() + "," + "age" + bean.getAge());
        test01 test01 = new test01();
        test01.method();

    }

}
