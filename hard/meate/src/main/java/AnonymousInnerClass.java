public class AnonymousInnerClass {
    public static void main(String[] args) {
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎嗷嗷叫~");
            }
        };
        System.out.println(tiger.getClass());
    }
}
//接口
interface  IA {
  public void cry();
}

class Tiger implements  IA{

    @Override
    public void cry() {
        System.out.println("老虎嗷嗷叫");
    }
}
