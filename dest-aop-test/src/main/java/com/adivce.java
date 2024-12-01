package com;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class adivce {
    @Around("@annotation(com.AroundCutPoint)")
    public Object aroundCutPoint(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        System.out.println("注解形式调用");
        System.out.println("test01---");
        try {
            proceed = joinPoint.proceed();
            System.out.println("test02----");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  proceed;
    }

    @Before("@annotation(com.BeforeCutPoint)")
    public void beforeCutePoint(){
        System.out.println("前置通知---googogo!!");
    }

    @After("@annotation(com.AfterCutPoint)")
    public void afterCutePoint(){
        System.out.println("后置通知----ddddd");
    }
}
