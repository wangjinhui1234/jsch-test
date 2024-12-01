package zeroonepages;

public class Test0101 {
    public static void main(String[] args) {
        int[] value = {15, 20, 30};
        int[] weight = {1, 3, 4};
        int i = pagemaxValue(weight, value, 4);
        System.out.println(i);

    }

    public static int pagemaxValue(int[] weight, int[] value, int valueprice) {
        int m = weight.length;
        int n = valueprice;
        int[][] dp = new int[m][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i =1; i <= n; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

            for (int j = 0; j < m; j++) {
                for (int i = 0; i <=n; i++) {
                System.out.print(dp[j][i]+ "\t");
            }
            System.out.println("\n");
        }
        return dp[m -1][n];
    }
}

