package zeroonepages;

public class Test0102 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int i = maxValue(weight, value, 4);
        System.out.println(i);
    }

    public static int maxValue(int[] weight, int[] value, int bagSize) {
        int m = weight.length;
        int[][] dp = new int[m][bagSize + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    System.out.println(dp[i][j]);
                    dp[i][j] = Math.max(dp[i -1][j],dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <=bagSize; j++) {
                System.out.print(dp[i][j]+ "\t");
            }
            System.out.println("\n");
        }

        return dp[m -1][bagSize];
    }
}
