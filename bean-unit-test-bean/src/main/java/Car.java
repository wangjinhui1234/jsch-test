import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    private Engine engine;
    public String name;


    // 构造器注入 Engine
    public Car(Engine engine) {
        this.engine = engine;
    }

    //
    /*
     *
     * engine
     *
     *
     *
     * */

    //test()
    //test //
    // test01  test01(){}
    // test01(){
    // test01(}
    // test01(){

    //
    //
    // //
    //
    // }
    //
    //
    // }
    public void test() {
        //
        test();


    }


    @Autowired
    public Car(Engine engine, String name) {
        this.name = name;
        this.engine = engine;
    }


    public void drive() {
        System.out.println("Driving with engine type: " + engine.getType() + name);
    }
}
