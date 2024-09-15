package async;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.*;

public class AsyncSFTPDownloadWithThreadPool {

    public static void main(String[] args) {
        String host = "192.168.10.100";
        int port = 22;
        String user = "dkbs";
        String password = "123456";

        String[] remoteFiles = {"/home/dkbs/test/large_files/largefile_1.bin", "/home/dkbs/test/large_files/largefile_2.bin", "/home/dkbs/test/large_files/largefile_3.bin", "/home/dkbs/test/large_files/largefile_4.bin"};  // 远程文件列表
        String[] localFiles = {"D:\\test\\largefile_1.bin", "D:\\test\\largefile_2.bin", "D:\\test\\largefile_3.bin", "D:\\test\\largefile_4.bin"};  // 本地文件路径列表
        // 创建一个固定大小的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);  // 限制同时运行的线程数量为5

        // 创建 CompletableFuture 数组来追踪下载任务
        CompletableFuture<Void>[] downloadFutures = new CompletableFuture[remoteFiles.length];

        for (int i = 0; i < remoteFiles.length; i++) {
            String remoteFile = remoteFiles[i];
            String localFile = localFiles[i];

            // 提交下载任务到线程池，并且用 CompletableFuture 管理
            downloadFutures[i] = CompletableFuture.runAsync(() ->
                    downloadFile(host, port, user, password, remoteFile, localFile), threadPool)
                    .thenRun(() -> System.out.println("文件下载成功: " + remoteFile))
                    .exceptionally(ex -> {
                        System.out.println("文件下载失败: " + remoteFile);
                        ex.printStackTrace();
                        return null;
                    });
        }

        // 等待所有任务完成
        CompletableFuture<Void> allDownloads = CompletableFuture.allOf(downloadFutures);

        try {
            allDownloads.get();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 关闭线程池
        threadPool.shutdown();
    }

    // 下载文件的方法
    public static void downloadFile(String remoteHost, int port, String username, String password, String remoteFile, String localFile) {
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;

        try {
            session = jsch.getSession(username, remoteHost, port);
            session.setPassword(password);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();

            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            try (OutputStream os = new FileOutputStream(localFile)) {
                channelSftp.get(remoteFile, os);  // 下载文件
            }

        } catch (Exception e) {
            throw new RuntimeException("下载文件失败: " + remoteFile, e);
        } finally {
            if (channelSftp != null) {
                channelSftp.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
}

