package other;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;
import java.io.InputStream;

public class JarXmlResourceExample {

    public static void main(String[] args) throws IOException {
        // 创建一个资源模式解析器
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        // 使用 AntPathMatcher 处理路径模式
        AntPathMatcher pathMatcher = new AntPathMatcher();
        resolver.setPathMatcher(pathMatcher);

        // 定义在 JAR 包中的 .xml 文件路径模式
        String resourcePattern = "classpath*:*.xml";

        // 使用资源模式解析器获取匹配的 .xml 文件资源
        Resource[] resources = resolver.getResources(resourcePattern);

        // 遍历资源并处理
        for (Resource resource : resources) {
            // 获取资源的 URL
            System.out.println("XML Resource URL: " + resource.getURL());

            // 获取资源的文件名
            String fileName = resource.getFilename();
            System.out.println("XML File Name: " + fileName);

            // 使用资源的 InputStream 处理资源内容
            try (InputStream inputStream = resource.getInputStream()) {
                // 在这里处理资源的输入流，比如读取 XML 内容等
                // ...
            }
        }
    }
}

