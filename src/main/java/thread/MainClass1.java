package thread;

public class MainClass1 {
    public static void main(String[] args) {
        System.out.println("MainClass1 is running in thread: " + Thread.currentThread().getName());
        MainClass2.main(args); // 调用另一个类的 main 方法
    }
}

class MainClass2 {
    public static void main(String[] args) {
        System.out.println("MainClass2 is running in thread: " + Thread.currentThread().getName());
    }
}
