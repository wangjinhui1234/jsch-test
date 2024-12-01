package com;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {


    @Around("execution(* com.SampleService.doSomething())")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) {
        Object proceed = null;

        long start = System.currentTimeMillis();
        try {

            System.out.println("这是是1");
            proceed = joinPoint.proceed();
            long l = System.currentTimeMillis() - start;
            System.out.println(joinPoint.getSignature() + "executed in" + l + "ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Hhehe");
        return proceed;
    }


}
