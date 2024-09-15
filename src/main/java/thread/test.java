package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadExample.main(new String[1]);
        printThreadInfo("task4");
        CompletableFuture<String> future = CompletableFuture.completedFuture("Hello, World!");
        printThreadInfo("task5");
        System.out.println(future.get());

    }

    private static void printThreadInfo(String taskName) {
        // 打印当前线程的信息
        System.out.println(taskName + " is running on thread: " + Thread.currentThread().getName());
    }
}
