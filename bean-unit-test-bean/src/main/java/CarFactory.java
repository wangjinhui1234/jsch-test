public class CarFactory {

    // 工厂方法创建 Car 实例
    public static Car createCar(Engine engine) {
        return new Car(engine);
    }
}

