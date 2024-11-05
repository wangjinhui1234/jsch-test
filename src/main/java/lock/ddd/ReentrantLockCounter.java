package lock.ddd;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
    private int count = 0;               // 计数器
    private final ReentrantLock lock = new ReentrantLock();//可重入锁

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                reentrantLockCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                reentrantLockCounter.increment();
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("reetrancount ->" + reentrantLockCounter.getCount());
    }
}
