package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {

    private final ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        ThreadExample example = new ThreadExample();
        example.startTasks();
    }

    public void startTasks() {
        // 创建异步任务
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            printThreadInfo("Task 1");
        }, threadPool);

        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            printThreadInfo("Task 2");
        }, threadPool);

        // 等待所有任务完成
        CompletableFuture.allOf(task1, task2).join();
        printThreadInfo("taskt3");
        // 关闭线程池
        threadPool.shutdown();
    }

    private void printThreadInfo(String taskName) {
        // 打印当前线程的信息
        System.out.println(taskName + " is running on thread: " + Thread.currentThread().getName());
    }
}
