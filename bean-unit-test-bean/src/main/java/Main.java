import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 创建 Spring 应用上下文
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 获取 Car Bean
        Car car = context.getBean(Car.class);

        // 使用 Car
        car.drive(); // 输出 "Driving with engine type: V8"
    }
}
