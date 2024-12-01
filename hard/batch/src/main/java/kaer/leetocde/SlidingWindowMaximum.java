package kaer.leetocde;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        Queue<Integer> ap1 = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));

        for (Map.Entry<Integer,Integer> en: map.entrySet()
             ) {

        }
        for (Integer str: map.keySet()) {

        }
        for (Integer in:map.values()
             ) {

        }
        for (Map.Entry<Integer,Integer> ap : map.entrySet()){
            Integer key = ap.getKey();
            Integer value = ap.getValue();
        }
        for (Integer s: map.keySet()){
            Integer integer = map.get(s);
        }

        Map<Integer,Integer> map1 = new HashMap<>();
        for (Integer i: map.values()){

        }

        PriorityQueue<int[]> integers = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[2]));
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>(); // 存储数组索引

        for (int i = 0; i < n; i++) {
            // 维护双端队列，保证队列中的元素从大到小排列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offer(i); // 将当前索引添加到队列

            // 检查窗口是否完全覆盖到了数组
            if (i >= k - 1) {
                // 检查队列头部元素是否在当前窗口范围内
                if (deque.peekFirst() < i - k + 1) {
                    deque.pollFirst(); // 移除队列头部元素
                }
                // 记录当前窗口的最大值（即队列头部元素对应的值）
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result));
    }
}
