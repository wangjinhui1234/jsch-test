package cglib;

import net.sf.cglib.proxy.Enhancer;

import javax.xml.ws.Service;

public class cgMain {
    public static void main(String[] args) {
        //创建cglib对象，用于生成代理对象
        Enhancer enhancer = new Enhancer();

        //设置父类,即 被代理的目标类
        enhancer.setSuperclass(gbService.class);

        //设置方法拦截器，用于拦截代理对象的方法调用
        enhancer.setCallback(new ServiceMethodInterceptor());

        //创建代理对象
        gbService proxy = (gbService) enhancer.create();

        proxy.execute();

    }
}
