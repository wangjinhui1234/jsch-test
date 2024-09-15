package threadTest;

public class DaemonThreadExample {
    public static void main(String[] args) {
        // 创建一个用户线程
        Thread userThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("User thread running");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 创建一个守护线程
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 设置守护线程
        daemonThread.setDaemon(true);

        // 启动线程
        userThread.start();
        daemonThread.start();

        // 主线程等待用户线程完成
        try {
            userThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 当用户线程结束时，守护线程也会被终止
        System.out.println("Main thread ends.");
    }
}
