package definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        String s = "";
        s.length();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

        }

        sb.append("").append("");
        HashSet<Integer> set = new HashSet<Integer>();

        set.add(1);
        for (Object s1 : set
        ) {

            System.out.println(s1);
        }
        set.stream().mapToInt(x -> x).toArray();

        HashMap<String, String> map = new HashMap<>();


        //map.put(1,map.getOrDefault(1,""));
        map.put("d", "d");
        map.put("ee", "df");
        Collection<String> values = map.values();
        for (String va : values
        ) {
            System.out.println(va);
        }
        for (int i = 0; i < 5; i++) {

        }
        for (int i = 0; i < 5; i++) {
            // Arrays.stream(arr).collect();
        }
        Person person = new Person("DD", 11, null);
        Date date = person.getDate();
        System.out.println();
        System.out.println(date);
        System.out.println("=================================================");

        int i = totalFruit(arr);
        try {
            System.out.println(i);
            LinkedList<String> str = new LinkedList<>();
            Long l = null;
            // long s = l / 1000;
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int max = 0;
        int min = Integer.MAX_VALUE;

        while (right < len) {
            max += nums[right];
            while (max >= target) {
                min = Math.min(min, right - left + 1);
                max = max - nums[left];
                left++;
            }
            right++;
        }
        return min;
    }


    public static int totalFruit(int[] fruits) {
        int left = 0;
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
