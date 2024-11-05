package lock;

public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedCounter.increment();
            }
        }
        );


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedCounter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("final thread" + synchronizedCounter.getCount());
        //等待线程
    }
}

class SynchronizedCounter {
    private int count = 0;

    //使用synchronized方法
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
