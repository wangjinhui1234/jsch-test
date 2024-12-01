package zeroonepages;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        // 创建一个数组用于保存每个数对应的最小完全平方数数量
        int[] dp = new int[n + 1];

        // 初始化数组，将每个位置都初始化为最大值，即 n，因为最多需要 n 个 1 的平方
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 0 的平方数数量为 0
        dp[0] = 0;

        // 动态规划递推
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // 尝试使用 j * j 这个平方数
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j ++) {
                System.out.print(dp[j]+ "\t");
            }
            System.out.println("\n");
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        int n = 12;
        int result = perfectSquares.numSquares(n);
        System.out.println("最小完全平方数数量: " + result);
    }
}

