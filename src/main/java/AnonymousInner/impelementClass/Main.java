package AnonymousInner.impelementClass;

public class Main {
    public static void main(String[] args) {
        // 使用匿名内部类继承 Animal 类并重写 sound 方法
        Animal animal = new Animal() {
            @Override
            public void sound() {
                System.out.println("Roar!");
                System.out.println(status + name);
            }
        };
        Animal animal1 = new Animal() {

        };
        // 调用匿名内部类的重写方法
        animal.sound(); // 输出：Roar!
    }
}
