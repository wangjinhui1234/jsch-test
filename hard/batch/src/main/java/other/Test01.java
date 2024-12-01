package other;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.time.LocalDateTime;
public class Test01 {
    public static void main(String[] args) throws IOException {

     String str = " t s ";
        String trim = str.trim();
        System.out.println(trim);
        String[] patten ={
            // "/test/bat*/t*.xml",
                "src/main/java/*.xml",
                "\\project\\demo-sp-Test\\src\\main\\java\\sp4.xml"
     };
        for (String  path:patten) {
            try {
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                //  Resource[] resources = resolver.getResources("/test/batch/*.xml");
                    Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(null).getResources(path);
               // System.out.println(resources.length);

                for (Resource res : resources
                ) {
                    System.out.println("-----");
                    System.out.println(res.getFilename());
                }
                // findTargetSumWays(2, "ddddd");
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public static int findTargetSumWays(int num, String str, Object... paramValues) {
        int count = 0;
        System.out.println("paramValues.length->" + paramValues.length);
        for (int ii = 0; ii < paramValues.length; ii++) {
            count++;
            System.out.println("count->" + count);
        }
        return 1;
    }
}
