package Single.ehanjiazai;

public class ESingle {
    private static ESingle eSingle = new ESingle();

    private ESingle() {
    }

    public static ESingle get() {
        return eSingle;
    }
}
