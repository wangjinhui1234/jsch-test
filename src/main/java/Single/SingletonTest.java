package Single;
public class SingletonTest {
    public static void main(String[] args) {
        // 获取两个实例
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // 判断两个实例是否相同
        if (instance1 == instance2) {
            System.out.println("Test passed: Both instances are the same.");
        } else {
            System.out.println("Test failed: Instances are different.");
        }
    }
}
