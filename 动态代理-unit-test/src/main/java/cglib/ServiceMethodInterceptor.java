package cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ServiceMethodInterceptor implements MethodInterceptor {


    // 2. 创建方法拦截器，实现 MethodInterceptor 接口
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before executing service...");//在方法调用前执行
        Object result = methodProxy.invokeSuper(o, objects);//调用父类，即目标对象的方法
        System.out.println("After executing service ...");//在方法调用后执行的逻辑
        return result;
    }


}
