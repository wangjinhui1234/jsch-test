package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filterstream {
    public static void main(String[] args) {
       /* int  pageNum = 0;


        do {
            System.out.println("->>>>>"+ pageNum);
            pageNum ++;
            System.out.println(pageNum);
        }while (100 >pageNum);*/
        String str  ="ddd";
        String str1 = "ddd";
        String str2 ="ddd";
        String str3 = "dd";
        System.out.println(System.identityHashCode(str));
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));

        System.out.println(System.identityHashCode(str3));
        int a = -129;
        int b =-129;
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
    }
}
