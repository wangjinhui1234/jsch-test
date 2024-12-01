package zeroonepages;

public class TestMaxValueOneWei {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int i = valuePrice(weight, value, 4);
        System.out.println(i);
    }

    public static int valuePrice(int[] weight, int[] value, int bagSize) {
        int m = weight.length;
        int[] dp = new int[bagSize + 1];
        // 0 -i  最大价值 dp[j]  j是重量
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagSize];
    }
}
