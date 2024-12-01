package zeroonepages;

import java.util.Arrays;

public class canPartition {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
    public static boolean canPartition(int[] nums) {
        int m = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target  = sum /2;
        if( sum % 2 != 0) return false;
        //初始化dp数组
        int[][] dp = new int[m][target + 1];

        for (int i = 0; i<m; i++){
            dp[i][0] = 0;
        }

        for (int i = 1; i <= target; i++){
            dp[0][i]= nums[0];
        }
        for (int i = 1 ; i < m ;i++){
            for(int j = 1; j <= target;j++){
                if(j < nums[i]){
                    dp[i][j] = dp[i -1][j];
                }else{
                    dp[i][j] = Math.max(dp[i -1][j],dp[i-1][j -nums[i]] + nums[i]);
                }
            }
        }
        return dp[m -1][target] == target;
    }
}
