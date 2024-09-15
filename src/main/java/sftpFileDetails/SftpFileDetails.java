package sftpFileDetails;

import com.jcraft.jsch.*;

import java.text.SimpleDateFormat;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp.LsEntry;

public class SftpFileDetails {
    public static void main(String[] args) {
        String host = "192.168.10.100";
        int port = 22;
        String user = "dkbs";
        String password = "123456";
        //String command = "ls /tools";  // 要执行的命令
        String remoteDirectory = "/home/dkbs/test/large_files";


        JSch jsch = new JSch();
        Session session = null;

        try {
            // 创建 session
            session = jsch.getSession(user, host, port);
            session.setPassword(password);

            // 禁用主机 key 检查（根据需要处理证书验证）
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            // 打开 SFTP 通道
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;


            // 列出远程目录下的文件
            Vector<LsEntry> fileList = sftpChannel.ls("/home/dkbs/test/large_files/*job*");


            // 遍历文件列表
            for (LsEntry entry : fileList) {
                // 获取文件名
                String fileName = entry.getFilename();

                // 忽略 . 和 .. 目录
                if (fileName.equals(".") || fileName.equals("..")) {
                    continue;
                }

                // 获取文件大小
                long fileSize = entry.getAttrs().getSize();

                // 获取修改时间
                long mTime = entry.getAttrs().getMTime() * 1000L; // 秒转换为毫秒
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(mTime);

                // 拼接文件的全路径
                String fullPath = remoteDirectory + "/" + fileName;

                // 打印文件详细信息
                System.out.println("文件路径: " + fullPath);
                System.out.println("文件大小: " + fileSize + " bytes");
                System.out.println("修改时间: " + formattedDate);
                System.out.println("----------------------------------------");
            }

            // 关闭通道和 session
            sftpChannel.disconnect();
            session.disconnect();
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }
    }
}

