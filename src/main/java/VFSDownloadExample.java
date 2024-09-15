import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

import java.io.File;

public class VFSDownloadExample {

    public static void main(String[] args) {
        String sftpUri = "sftp://your_username:your_password@your.server.com/path/to/yourfile.jar";
        String localPath = "/local/path/to/save/yourfile.jar";

        StandardFileSystemManager manager = new StandardFileSystemManager();
        try {
            manager.init();

            FileSystemManager fsManager = VFS.getManager();
            FileObject remoteFile = fsManager.resolveFile(sftpUri);
            FileObject localFile = fsManager.resolveFile(new File(localPath).getAbsolutePath());

            localFile.copyFrom(remoteFile, null);
            System.out.println("File downloaded successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}
