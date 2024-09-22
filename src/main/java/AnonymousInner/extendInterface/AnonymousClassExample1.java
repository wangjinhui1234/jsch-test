package AnonymousInner.extendInterface;

public class AnonymousClassExample1 {
    public static void main(String[] args) {
        // 使用匿名内部类实现 Runnable 接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现的 Runnable 运行中...");
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我自己创建匿名内部类");
            }
        };

        // 创建并启动线程
        Thread thread = new Thread(runnable);


        thread.start();
        Thread thread1 = new Thread(runnable1);
        thread1.start();
    }
}
