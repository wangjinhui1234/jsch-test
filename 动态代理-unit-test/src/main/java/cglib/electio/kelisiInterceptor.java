package cglib.electio;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class kelisiInterceptor implements MethodInterceptor {

    private final Object target;

    public kelisiInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        int value = 0;
        System.out.println("如果特朗普得票居高不下，执行暗杀行动");
        if (objects != null && objects.length > 0 && objects[0] instanceof Integer) {
            value = (Integer) objects[0];
        }

        if (value == 8) {
            objects[0] = 9;
            System.out.println("特朗普串改票数" + 9);
        }
        Object result = methodProxy.invoke(o, objects);
        if (value >= 10) {
            System.out.println("克里斯下令执行暗杀,不能让特朗普当总统");
        } else {
            System.out.println("不需要执行暗杀");
        }

        return result;
    }
}
