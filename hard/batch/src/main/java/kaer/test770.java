package kaer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test770 {
    public static void main(String[] args) {
        int[] dp = {-4,-1,0,3,10};
        List<Integer> integers = Arrays.asList(1, 6, 4, 78, 66, 1, 5);
        List<Integer> integerList = integers.stream().sorted(Comparator.comparing(Integer::valueOf,Comparator.nullsLast(Comparator.reverseOrder()))).collect(Collectors.toList());
        System.out.println(integerList);
        for (Integer sort:integerList) {
            System.out.println(sort);

        }
        int[] ints = sortedSquares(dp);
        int a = 0;
        int b = 1;
        System.out.println();
        Instant startInstant = Instant.parse("2024-03-11T" +
                "12:00:00Z");
        Instant endInstant = Instant.parse("2024-03-11T11:00:00Z");

        long millis = ChronoUnit.MILLIS.between(startInstant, endInstant);


        System.out.println("Milliseconds between: " + millis);


    }
    public static int[] sortedSquares(int[] nums) {
        int m = nums.length;
        int[] result = new int[m ];
        int k = 0;

        for (int i = 0,j = m - 1; i <= j;  ){
            if (nums[i] * nums[i] > nums[j] * nums[j]){
                result[k] = nums[i] * nums[i];
                i++;
            }else {

                result[k] = nums[j] * nums[j];
                j--;
            }
            k++;
        }
        return result;
    }
}
