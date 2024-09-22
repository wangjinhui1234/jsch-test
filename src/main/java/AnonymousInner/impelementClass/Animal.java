package AnonymousInner.impelementClass;

// 定义一个父类
public class Animal {
    public String name;
    public String status;
    public Animal(){
        name ="测试名";
        status = "状态标志";
    }
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}