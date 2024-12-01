package excesie01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bubble_sort {
    public static void main(String[] args) {
// FIXME: 2024/6/3
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcdefg");

       // stringBuilder.insert(3,"mmm");
        System.out.println(stringBuilder.toString());
        ArrayList<Object> objects = new ArrayList<>();
        //  List<Integer> bubbList =  Arrays.asList(24, 69, 57, 13, 80);
        int[] bubb2= {24, 69, 57, 13, 80};

        int step ;
       for (int i = 0; i < bubb2.length - 1;i++){
           for (int j = 0; j < bubb2.length -1 -i; j++) {
               if (bubb2[j] > bubb2[j + 1]){
                   step = bubb2[j];
                   bubb2[j] = bubb2[j + 1];
                   bubb2[j + 1] = step;
               }
           }
       }
        for (int i:bubb2) {
            System.out.print(i + " ");
        }



    }
}
