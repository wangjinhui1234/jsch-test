package zeroonepages;

public class Test06 {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i * i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i * i) {
                    dp[j] = Math.min(dp[j], dp[j - (i * i)] + 1);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int[] nums = {12};
        int targetSumWays = numSquares(12);
        System.out.println(targetSumWays);

    }

}
