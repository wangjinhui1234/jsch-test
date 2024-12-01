package other;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        // 使用 ResouTrcePatternResolver 获取资源
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
        String resourcePattern = "classpath*:/test/batch/cr.xml";

        try {
            Resource[] resources = resolver.getResources(resourcePattern);

            for (Resource resource : resources) {
                // 处理获取到的资源
                System.out.println("Found resource: " + resource.getURL());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

