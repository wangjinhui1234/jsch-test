package cglib.electio;

import net.sf.cglib.proxy.Enhancer;

public class selectionMain {
    public static void main(String[] args) {

        chuanpu chuanpu = new chuanpu();
        chuanpu proxy = (chuanpu) Enhancer.create(chuanpu.getClass(), new kelisiInterceptor(chuanpu));
        proxy.selected(10);
    }
}
