package exception;

public class Test {
    public static void main(String[] args) {
        String s = "";
        if (s == "") {
            throw new NullPointerException("我这里就是想报错");
        }
    }
}
