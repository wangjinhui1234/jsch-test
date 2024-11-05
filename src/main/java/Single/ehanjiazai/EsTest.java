package Single.ehanjiazai;

public class EsTest {
    public static void main(String[] args) {
        ESingle eSingle = ESingle.get();
        ESingle eSingle1 = ESingle.get();
        if (eSingle == eSingle1) {
            System.out.println("是同一个对象，这验证了饿汉式加载" + eSingle.toString() + "+++" + eSingle1.toString());
        } else {
            System.out.println("不是同一个对象");
        }

    }
}
