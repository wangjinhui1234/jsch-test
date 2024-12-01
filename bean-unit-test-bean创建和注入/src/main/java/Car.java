public class Car {
    private Engine engine;

    // 构造器注入 Engine
    public Car(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void drive() {
        System.out.println("Driving with engine type: " + engine.getType());
    }
}
