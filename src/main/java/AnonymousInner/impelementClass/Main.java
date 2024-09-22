package AnonymousInner.impelementClass;

// 定义一个父类
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Main {
    public static void main(String[] args) {
        // 使用匿名内部类继承 Animal 类并重写 sound 方法
        Animal animal = new Animal() {
            @Override
            void sound() {
                System.out.println("Roar!");
            }
        };
       new Animal();
        // 调用匿名内部类的重写方法
        animal.sound(); // 输出：Roar!
    }
}
