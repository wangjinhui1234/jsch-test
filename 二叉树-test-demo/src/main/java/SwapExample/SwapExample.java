package SwapExample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SwapExample {
    public static void main(String[] args) {
        Integer a = 3;
        Integer b = 5;
        System.out.println("Before swap: a = " + a + ", b = " + b);


        IntFunction<String> function = Integer::toString;
        // 尝试交换 a 和 b 的值
        List<Integer> list = new ArrayList<>();
        String collect = list.stream().map(String::valueOf).collect(Collectors.joining("->"));
        swap(a, b);
        int[] numbers = {1, 2, 3, 4, 5};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("helloo, runnable");
            }
        };
        runnable.run();


        String result = IntStream.of(numbers).mapToObj(String::valueOf)
                .collect(Collectors.joining("->"));
        System.out.println(result);


        // 结果没有变化
        System.out.println("After swap: a = " + a + ", b = " + b);
    }

    public static void swap(Integer x, Integer y) {
        Integer temp = x;
        x = y;
        y = temp;
    }
}
