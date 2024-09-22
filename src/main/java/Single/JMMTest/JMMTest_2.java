package Single.JMMTest;

import java.util.concurrent.TimeUnit;

public class JMMTest_2 {
    public static volatile boolean flag = false;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                System.out.println("线程1开始");
                while (!flag) {
                    count++;
                    System.out.println("计数器" + count);
                }
                System.out.println("线程1开始");
            }
        }).start();

         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2开始");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    change();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程2结束");
            }
        }).start();

    }
    public static void change(){
        flag = true;
    }
}
