package jdk.election;

import java.lang.reflect.Proxy;

public class PTMain {
    public static void main(String[] args) {
        PT tlp = new TLP();
        PT proxy = (PT) Proxy.newProxyInstance(tlp.getClass().getClassLoader(), tlp.getClass().getInterfaces(), new TLPInvocation(tlp));
        proxy.congradulation("特朗普", 12);

    }
}
