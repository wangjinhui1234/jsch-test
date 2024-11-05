package compre;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class compressFile {
    public static void compressFile(String inputFile, String outputFile, int compressionLevel) throws IOException {
        Configuration conf = new Configuration();
        conf.setInt("zlib.compress.level", compressionLevel);

        FileSystem fs = FileSystem.get(conf);
        CompressionCodecFactory factory = new CompressionCodecFactory(conf);
        CompressionCodec codec = factory.getCodec(new Path(outputFile));

        if (codec == null) {
            throw new IOException("No codec found for file extension of " + outputFile);
        }

        try (InputStream inputStream = fs.open(new Path(inputFile));
             OutputStream outputStream = codec.createOutputStream(fs.create(new Path(outputFile)))) {

            IOUtils.copyBytes(inputStream, outputStream, conf);
            System.out.println("File compressed successfully to: " + outputFile);

        } finally {
            fs.close();
        }
    }

}
