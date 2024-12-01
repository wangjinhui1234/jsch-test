package jdk.logtest;

import java.lang.reflect.Proxy;

public class LogMain {
    public static void main(String[] args) {
        LogService logService = new LogServiceImpl();
        LogService logService1 = (LogService) Proxy.newProxyInstance(logService.getClass().getClassLoader(), logService.getClass().getInterfaces(), new LogInvocationHandler(logService));
        logService1.minitor();
    }
}
