package headfirst;

public class Amoeba extends Shape {
    @Override
    public void rotate() {
        super.rotate();
        System.out.println("你好,我是子类");

    }

    @Override
    public void playSound() {
        System.out.println("你好");
    }

    public static void main(String[] args) {
        Amoeba amoeba = new Amoeba();
        amoeba.rotate();
    }
}
