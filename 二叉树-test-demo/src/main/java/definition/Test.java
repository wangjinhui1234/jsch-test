package definition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int i = totalFruit(arr);
        System.out.println(i);
        LinkedList<String> str = new LinkedList<>();

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
