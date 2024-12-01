package jdk.election;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TLPInvocation implements InvocationHandler {
    private final Object targets;

    public TLPInvocation(Object targets) {
        this.targets = targets;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // System.out.println(proxy.toString());
        if (args != null && args.length > 0 && args[0] instanceof String) {
            if (args[0] == "特朗普") {
                System.out.println("俄罗斯和乌克兰得战争即将结束");
            } else {
                System.out.println("准备进攻基辅");
            }
        }
        Object invoke = method.invoke(targets, args);
        System.out.println("以色列战争依然进行中");

        return invoke;
    }
}
