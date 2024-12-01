package definition;

public class struct {
    int value;
    struct right;
    struct left;

    public struct(int value, struct right, struct left) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    public struct() {
    }

    public struct(int value) {
        this.value = value;
        System.out.println();
    }
}
