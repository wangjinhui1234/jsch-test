package targesum;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class targetSum {
    public static void main(String[] args) {
        int[] dp = {1,1,1,1,1};
        int i = targetSum(dp, 3);
        System.out.println(i);

    }

    public static int targetSum(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        int m = (count + target) / 2;
        //定义二维数组dp, 其中dp[i][j] 表示在数组sums得前i个数中选取元素，使得这些元素之和等于
        int[][] dp = new int[nums.length + 1 ][m + 1];
        //  dp[][] 表示    j =3
        /*     0  1  2   3   4
         *   0  1  1  1   1    1
         *   1  1
         *   2  1
         *   3  1
         *   4  1
         *
         * */
                for (int i = 0; i <=nums.length ; i++) {
                    dp[i][0] = 1;
                }
                for (int i = 0; i <= m; i++) {
                    dp[i][0] = 1;
                }
        for (int i = 1; i <= nums.length; i++) {
        for (int j = m ; j >=0 ; j--) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i - 1]) {
                        dp[i][j] += dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
        return  dp[nums.length][m];
    }
}

