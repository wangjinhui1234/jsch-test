package sshfilelist;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class SSHFileList {

    public static void main(String[] args) {
        String host = "192.168.10.100";
        int port = 22;
        String user = "dkbs";
        String password = "123456";
        String command = "ls /tools";  // 要执行的命令

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);

            // 跳过主机密钥检查（生产环境应慎重）
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);

            BufferedReader in = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
            channelExec.connect();

            String msg;
            System.out.println("你好");
            while ((msg = in.readLine()) != null) {
                System.out.println("File: " + msg);  // 输出文件名
            }
            System.out.println("这里执行完了");
            channelExec.disconnect();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
