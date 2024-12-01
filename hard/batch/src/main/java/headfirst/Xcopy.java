package headfirst;

public class Xcopy {
    public static void main(String[] args) {
       int i = 0/10;
        System.out.println(i);
        int orig = 42;
        Xcopy xcopy = new Xcopy();
        int go = xcopy.go(orig);
        System.out.println(go);
    }
    int go(int args){
        args = args  *2 ;
        return args;
    }
}
