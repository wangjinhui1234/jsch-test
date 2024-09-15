package 文件下载;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class SFTPDownload {

    public static void main(String[] args) {
        String host = "192.168.10.100";
        int port = 22;
        String user = "dkbs";
        String password = "123456";
        String remoteFile = "/tools/openssl-3.1.4.tar.gz";  // 远程服务器上的文件路径
        String localFile = "D:\\test\\openssl-3.1.4.tar.gz";  // 本地保存路径

        try {
            // 建立 Session
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);

            // 跳过主机密钥检查（仅用于测试环境）
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            // 打开 SFTP 通道
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();

            // 下载文件
            try (OutputStream os = new FileOutputStream(localFile)) {
                sftpChannel.get(remoteFile, os);
            }

            // 断开连接
            sftpChannel.disconnect();
            session.disconnect();

            System.out.println("File downloaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
