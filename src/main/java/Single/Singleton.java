package Single;
//懒汉式加载
public class Singleton {
    // 持有单例实例
    private static Singleton instance;

    // 私有构造函数，防止外部实例化
    private Singleton() {}

    // 提供全局访问点
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
