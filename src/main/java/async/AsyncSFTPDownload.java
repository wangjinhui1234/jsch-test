package async;


import async.Cloud.SftpClient;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class AsyncSFTPDownload {
    private static SftpClient sftpClient = null;

    public static void main(String[] args) {
        String host = "192.168.10.100";
        int port = 22;
        String user = "dkbs";
        String password = "123456";

        String[] remoteFiles = {"/home/dkbs/test/large_files/largefile_1.bin", "/home/dkbs/test/large_files/largefile_2.bin", "/home/dkbs/test/large_files/largefile_3.bin", "/home/dkbs/test/large_files/largefile_4.bin"};  // 远程文件列表
        String[] localFiles = {"D:\\test\\largefile_1.bin", "D:\\test\\largefile_2.bin", "D:\\test\\largefile_3.bin", "D:\\test\\largefile_4.bin"};  // 本地文件路径列表
        List<String> list = Arrays.asList(remoteFiles);
        List<String> list1 = Arrays.asList(localFiles);
        // 创建一个 CompletableFuture 数组来追踪每个文件的下载任务
        CompletableFuture<Boolean>[] downloadFutures = new CompletableFuture[remoteFiles.length];

        for (int i = 0; i < list.size(); i++) {
            String remoteFile = list.get(i);
            String localFile = list1.get(i);
            int count = i;
            sftpClient = new SftpClient();
            // 每个文件的异步下载任务
            downloadFutures[i] = CompletableFuture.supplyAsync(() -> {

                // boolean success = downloadFile(host, port, user, password, remoteFile, localFile);
                //封装下载对象
                Boolean success = sftpClient.download(remoteFile, localFile);
                System.out.println("下载完成" + "执行结果为" + success + list.get(count) + "本地文件名：" + list1.get(count));
                return success;
            }).exceptionally(Ex -> {
                System.out.println("发生异常" + list.get(count));
                return false;
            });

        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(downloadFutures);
        voidCompletableFuture.join();
        boolean match = Arrays.stream(downloadFutures).allMatch(CompletableFuture::join);

        if (match) {
            System.out.println("全部下载完成");
        } else {
            System.out.println("部分下载失败");
        }

    }

    // 下载文件的方法
    public static boolean downloadFile(String remoteHost, int port, String username, String password, String remoteFile, String localFile) {
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;
        boolean flag = false;
        try {
            // 1. 创建并连接会话
            session = jsch.getSession(username, remoteHost, port);
            session.setPassword(password);

            // 2. 设置 SSH 连接参数
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();

            // 3. 打开 SFTP 通道
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            // 4. 下载文件
            try (OutputStream os = new FileOutputStream(localFile)) {
                channelSftp.get(remoteFile, os);
            }
            flag = true;
        } catch (Exception e) {
            throw new RuntimeException("下载文件失败: " + remoteFile, e);  // 抛出异常
        } finally {
            // 5. 关闭连接
            if (channelSftp != null) {
                channelSftp.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
        return flag;

    }
}
