package cglib.warmode;

import net.sf.cglib.proxy.Enhancer;

public class WarMain {
    public static void main(String[] args) {
        //创建CGlib Enhancer 对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(War.class);
        enhancer.setCallback(new warIntercepter());

        //创建代理对象
        War proxy = (War) enhancer.create();

        proxy.hit();
        System.out.println(proxy.endSentence());

        System.out.println("============================");

    }
}
