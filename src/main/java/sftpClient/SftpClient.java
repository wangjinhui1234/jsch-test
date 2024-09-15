package sftpClient;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;


public class SftpClient implements AutoCloseable {
    private Session session;
    private ChannelSftp channelSftp;

    public SftpClient(String host, int port, String user, String passwd) {
        //初始化Session 和 ChannelSftp
        JSch jSch = new JSch();
        try {
            session = jSch.getSession(user, host, port);

            session.setConfig("StrickHostKeyCHecking", "no");
            session.setPassword(passwd);
            session.connect();
            //
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public void downloadFile(String remmoteFile, String localFile) {
        //文件下载逻辑
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile), 1024)) {
            channelSftp.get(remmoteFile, bufferedOutputStream);
        } catch (Exception e) {
            //异常
        }

    }

    @Override
    public void close() {
        if (channelSftp != null) {
            channelSftp.disconnect(); //sftp 连接关闭
        }
        if (session != null) {
            session.disconnect(); //自动关闭会话
        }
    }
}
