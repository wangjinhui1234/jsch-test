package async.Cloud;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class CloudDownloadTool {
    // 创建一个共享的固定大小线程池，最大并发数为 10
    private static final ExecutorService sharedThreadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        // 示例：用户1提交的下载任务
        List<CompletableFuture<Void>> user1Tasks = new ArrayList<>();
        submitDownloadTasks("user1", user1Tasks, "/remote/file1.txt", "D:/local/file1.txt");
        submitDownloadTasks("user1", user1Tasks, "/remote/file2.txt", "D:/local/file2.txt");
        notifyWhenAllTasksComplete(user1Tasks, "user1");

        // 示例：用户2提交的下载任务
        List<CompletableFuture<Void>> user2Tasks = new ArrayList<>();
        submitDownloadTasks("user2", user2Tasks, "/remote/file3.txt", "D:/local/file3.txt");
        submitDownloadTasks("user2", user2Tasks, "/remote/file4.txt", "D:/local/file4.txt");
        notifyWhenAllTasksComplete(user2Tasks, "user2");
    }

    // 提交文件下载任务
    public static void submitDownloadTasks(String user, List<CompletableFuture<Void>> taskList, String remoteFile, String localFile) {
        // 创建异步任务并加入任务列表
        CompletableFuture<Void> downloadTask = CompletableFuture.runAsync(() -> {
            try {
                System.out.println(user + " 开始下载文件：" + remoteFile);
                downloadFile(remoteFile, localFile);  // 模拟文件下载
                System.out.println(user + " 下载完成：" + remoteFile);
            } catch (Exception e) {
                System.err.println(user + " 下载文件失败：" + remoteFile);
                e.printStackTrace();
            }
        }, sharedThreadPool);

        // 添加到用户的任务列表
        taskList.add(downloadTask);
    }

    // 模拟文件下载的具体操作
    private static void downloadFile(String remoteFile, String localFile) throws InterruptedException {
        // 这里可以实现具体的文件下载逻辑，以下是模拟下载耗时
        Thread.sleep(2000);  // 模拟2秒钟的下载时间
    }

    // 等待所有任务完成，并通知前端
    private static void notifyWhenAllTasksComplete(List<CompletableFuture<Void>> taskList, String user) {
        // 使用 CompletableFuture 的 allOf 等待所有任务完成
        CompletableFuture<Void> allTasksFuture = CompletableFuture.allOf(
                taskList.toArray(new CompletableFuture[0])
        );

        // 所有任务完成后通知前端
        allTasksFuture.thenRun(() -> {
            System.out.println(user + " 的所有下载任务已完成，通知用户...");
            // 在这里发送通知给用户或前端
            shutdownThreadPool();
        }).exceptionally(ex -> {
            System.err.println("处理下载任务时出错！");
            ex.printStackTrace();
            return null;
        });
    }

    // 关闭线程池
    private static void shutdownThreadPool() {
        try {
            System.out.println("正在关闭线程池...");
            sharedThreadPool.shutdown();
            if (!sharedThreadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                sharedThreadPool.shutdownNow();
            }
            System.out.println("线程池已成功关闭。");
        } catch (InterruptedException e) {
            sharedThreadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
