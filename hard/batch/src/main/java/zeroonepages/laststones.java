package zeroonepages;

public class laststones {


    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        int i = lastStoneWeightII(stones);
        System.out.println(i);
    }


    public static int lastStoneWeightII(int[] stones) {
        int m = stones.length;
        int target = 0;
        for (int i = 0; i < stones.length; i++) {
            target += stones[i];
        }

        int weihgt = target / 2  ;
        //初始化dp数组
        int[][] dp = new int[m + 1][ weihgt + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = stones[0]; i <= weihgt; i++) {
            dp[0][i] = stones[0];
        }

        for (int i = 1; i <stones.length ; i++) {
            for (int j = 1; j <= weihgt; j++) {
                if (j >= stones[i]) {
                    //不放:dp[i - 1][j] 放:dp[i - 1][j - stones[i]] + stones[i]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= weihgt; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        int result = (target - dp[stones.length - 1][weihgt]) - dp[stones.length - 1][weihgt];
        return result;
    }
}
