package AnonymousInner.extendInterface;

// 定义一个接口
interface Greeting {
    void sayHello();
}

 class Main {
    public static void main(String[] args) {
        // 使用匿名内部类实现接口 Greeting
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, world!");
            }
        };

        // 调用匿名内部类的实现方法
        greeting.sayHello(); // 输出：Hello, world!
    }
}
