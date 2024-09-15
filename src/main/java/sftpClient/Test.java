package sftpClient;

import com.jcraft.jsch.JSchException;

public class Test {
    public static void main(String[] args) throws JSchException {
        SftpClient sftpClient = new SftpClient("", 1, "", "");
        sftpClient.downloadFile("", "");

    }
}
