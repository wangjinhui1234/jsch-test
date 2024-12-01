package zeroonepages;

public class targetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        // left  + right = sum
        // left - right = target;
        // 2left = sum + targt ;
        //left = (sum + target )/ 2
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if (((sum + target) % 2) !=0 ){
            return 0;
        }
        // dp[][]  - 0 - i 个数中， 和为 j 堆排【】【】 个方法；
        //dp数组   0 - i个数子中， 大小为 j
        int left =  (sum + target)/2;
        int  m =   nums.length;
        int[][] dp = new int[m][left + 1];

        for (int i = 0 ; i <m;i++) {
            dp[i][0] = 1;
        }
        for( int i = 1 ;i<= left;i++){
            dp[0][i] = 1;
        }
        for (int i = 1;i < m; i++){
            for (int j = 0; j<=left;j++){

                if(j >= nums[i] ) {
                    dp[i][j] += dp[i - 1][j - nums[i]] ;
                }else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= left; j ++) {
                System.out.print(dp[i][j]+ "\t");
            }
            System.out.println("\n");
        }
        return dp[m -1][left];
    }

    public static void main(String[] args) {
        int[] nums ={0,0,0,0,0};
        int targetSumWays = findTargetSumWays(nums, 0);
        System.out.println(targetSumWays);
    }
}
