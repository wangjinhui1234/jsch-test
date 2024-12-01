package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//创建代理处理器，负责拦截方法调用，并加入自定义的处理逻辑
public class ServiceInvocationHandler implements InvocationHandler {
    //目标对象，即被代理的对象
    private final Object target;

    //通过构造方法接收目标对象
    public ServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before executing service....");//在方法调用钱执行的逻辑
        Object result = method.invoke(target, args);
        System.out.println("After executing sercice ...");
        return result;
    }
}
