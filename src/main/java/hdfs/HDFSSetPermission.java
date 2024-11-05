package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;
import java.net.URI;

public class HDFSSetPermission {

    public static void main(String[] args) throws IOException {
        // HDFS URI
        String hdfsUri = "hdfs://your-hdfs-uri:8020";
        // 要设置权限的已存在文件或文件夹路径
        String pathToSetPermission = "/path/to/existing/file/or/directory";

        // 配置 Hadoop Configuration
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(hdfsUri), conf);

        // 设置权限，例如 755
        FsPermission permission = new FsPermission("755");

        // 通过 setPermission 方法设置文件或文件夹权限
        fs.setPermission(new Path(pathToSetPermission), permission);

        System.out.println("Permissions set successfully for: " + pathToSetPermission);

        // 关闭文件系统
        fs.close();
    }
}
