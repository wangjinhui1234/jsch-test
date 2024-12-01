import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 使用构造器创建 Engine Bean
    @Bean
    public Engine engine() {
        return new Engine("V8"); // 通过构造器创建 Engine 实例
    }

    // 使用构造器注入 Car Bean
    @Bean
    public Car car() {
        return CarFactory.createCar(engine()); // 通过构造器注入 Engine
    }
}
