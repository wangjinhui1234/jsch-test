package zeroonepages;

public class Test05 {
    public static void main(String[] args) {

            int[] nums ={1,1,1,1,1};
            int targetSumWays = findTargetSumWays(nums, 3);
            System.out.println(targetSumWays);

    }
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
        //dp数组   0 - i个数子中， 大小为 j
        int left =  (sum +  target)/2;
        int  m =   nums.length;
        int[] dp = new int[left + 1];
        dp[0] = 1;

        for (int i = 0;i < m; i++){
            for (int j = left; j>=nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= left; j ++) {
                System.out.print(dp[j]+ "\t");
            }
            System.out.println("\n");
        }

        return dp[left];
    }
}
//dp[j] += dp[j - nums[i]];