package definition;

public class TreeCur {
    public int val;
    public TreeCur leftCur;
    public TreeCur rightCur;

    public TreeCur(int val, TreeCur leftCur, TreeCur rightCur) {
        this.val = val;
        this.leftCur = leftCur;
        this.rightCur = rightCur;
    }

    public TreeCur(int val) {
        this.val = val;
    }


}

