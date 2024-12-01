package jdk;

import java.lang.reflect.Proxy;

public class invocationMain {
    public static void main(String[] args) {
        //创建目标对象
        MService serviceimpl = new ServiceImpl();

        //创建代理对象，通过Proxy.newProxyInstance动态代理
        MService proxyInstance = (MService) Proxy.newProxyInstance(serviceimpl.getClass().getClassLoader(), serviceimpl.getClass().getInterfaces(), new ServiceInvocationHandler(serviceimpl));

        //调用代理对象的方法，方法会被拦截，并执行自定义的前后逻辑
        proxyInstance.execute();
    }
}
