package thread;

import java.util.concurrent.CompletableFuture;

public class MainExample {
    public static void main(String[] args) {
        // 主线程打印
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // 创建一个新的线程
        Thread thread = new Thread(() -> {
            // 在新的线程中执行异步操作
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("Running in CompletableFuture thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);  // 模拟耗时任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Task completed!";
            });

            // 使用get()，阻塞的是新线程，而不是主线程
            try {
                String result = future.get(); // 这里会阻塞新线程
                System.out.println("Async task result: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 启动新线程
        thread.start();

        // 主线程继续执行，不会被阻塞
        System.out.println("Main thread continues: " + Thread.currentThread().getName());
    }
}
