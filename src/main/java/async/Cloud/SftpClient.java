package async.Cloud;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SftpClient implements AutoCloseable {
    private Session session;
    private ChannelSftp channelSftp;
    private static String host;
    private static String username;
    private static String password;
    private static int port;

    public SftpClient() {
        try {
            host = "192.168.10.100";
            port = 22;
            username = "dkbs";
            password = "123456";
            JSch jsch = new JSch();
            session = jsch.getSession(username, host, port);
            session.setPassword(password);

            // 2. 设置 SSH 连接参数
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            //session.setTimeout(10 * 60000);

            // 3. 打开 SFTP 通道
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
        } catch (Exception e) {
            System.out.println("初始化异常" + e);
        }
    }

    public boolean download(String remoteFile, String localFile) {
        long start = System.currentTimeMillis();
        try {
            channelSftp.get(remoteFile, localFile);

        } catch (Exception e) {
            System.out.println("下载文件异常");
            close();
            return false;
        }
        close();
        return true;
    }

    @Override
    public void close() {
        if (channelSftp != null) {
            channelSftp.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}
