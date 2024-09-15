import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ScpDownload {

    public static void main(String[] args) {
        String host = "192.168.10.100"; // Linux 服务器的 IP 地址
        String user = "dkbs";        // 登录用户名
        String password = "123456";    // 登录密码
        String remoteFile = "/home/dkbs/app/lib/test/1.txt"; // 服务器上的文件路径
        String localFile = "D:\\test\\1.txt"; // 本地保存文件的路径

        JSch jsch = new JSch();
        Session session = null;

        try {
            // 创建并连接会话
            session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            // 打开 SCP 执行通道
            String command = "scp -f " + remoteFile;
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);

            // 获取输入流并发起文件传输
            InputStream in = channel.getInputStream();
            channel.connect();

            byte[] buffer = new byte[1024];
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
            int bytesRead;

            // 读取文件数据
            while ((bytesRead = in.read(buffer)) > 0) {
                System.out.println("11");
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

            bufferedOutputStream.close();
            channel.disconnect();
            session.disconnect();


            System.out.println("File downloaded successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

