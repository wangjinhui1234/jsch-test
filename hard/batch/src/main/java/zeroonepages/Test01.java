package zeroonepages;

public class Test01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int method = method(4, weight, value);
        System.out.println(method);
    }

    public static int method(int n, int[] weight, int[] value) {
        int m = weight.length;
        int[][] dp = new int[m][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <=n; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
              /*  if (j > weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }*/
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


     /*   for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }*/
       // }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <=n; j++) {
                System.out.print( dp[i][j] + "\t");
            }
            System.out.println("\n");
        }


        return dp[weight.length - 1][n];
    }
}
