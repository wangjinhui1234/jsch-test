package cglib.warmode;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class warIntercepter implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("拜登秘密监视俄罗斯行动,安插间谍");
        //调用目标方法
        Object result = methodProxy.invokeSuper(o, objects);

        //方法调用后的逻辑
        System.out.println("俄罗斯突击计划失败");

        return result;
    }
}
