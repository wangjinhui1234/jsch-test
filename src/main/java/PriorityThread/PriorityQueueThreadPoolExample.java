package PriorityThread;

import java.util.concurrent.*;


public class PriorityQueueThreadPoolExample {

    // 定义任务类，实现 Comparable 接口以按优先级排序
    static class PriorityTask implements Runnable, Comparable<PriorityTask> {
        private final int priority;
        private final String taskName;

        public PriorityTask(int priority, String taskName) {
            this.priority = priority;
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println("Executing Task " + taskName + " with priority " + priority + " on Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);  // 模拟任务执行
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task " + taskName + " was interrupted");
            }
        }

        @Override
        public int compareTo(PriorityTask other) {
            // 高优先级任务排在前面
            return Integer.compare(other.priority, this.priority);
        }

        @Override
        public String toString() {
            return "Task{name='" + taskName + "', priority=" + priority + "}";
        }
    }

    public static void main(String[] args) {
        // 创建一个优先级阻塞队列
        // 创建一个阻塞队列
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        // 创建一个线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,   // 核心线程数
                4,   // 最大线程数
                1,   // 空闲线程超时时间
                TimeUnit.MINUTES,
                queue  // 使用优先级队列作为任务队列
        );

        // 提交多个任务到线程池
        executor.submit(new PriorityTask(1, "Low Priority Task"));
        executor.submit(new PriorityTask(3, "High Priority Task"));
        executor.submit(new PriorityTask(2, "Medium Priority Task"));

        // 启动线程池，确保所有核心线程开始执行任务
        executor.prestartAllCoreThreads();

        // 关闭线程池
        executor.shutdown();

        try {
            // 等待线程池关闭，确保所有任务完成
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

