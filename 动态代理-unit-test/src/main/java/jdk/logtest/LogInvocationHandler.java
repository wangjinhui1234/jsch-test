package jdk.logtest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class LogInvocationHandler implements InvocationHandler {
    private final Object target;// 目标对象


    public LogInvocationHandler(Object target) {
        this.target = target; //目标对象
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在这个逻辑之前假如的内容
        System.out.println("中国创建陷阱：棱镜门陷阱");
        System.out.println(proxy.getClass());
        Object result = method.invoke(target, args);
        //在这个逻辑之后加入的内容
        System.out.println("棱镜门惨遭灭门");
        return result;
    }
}
