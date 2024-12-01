package targesum;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // 计算数组和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果数组和小于目标和，或者和与目标和的差值为奇数，无法得到目标和
        if (sum < S || (sum + S) % 2 != 0) {
            return 0;
        }

        // 计算目标和的背包容量
        int target = (sum + S) / 2;

        // 初始化二维数组
        int[][] dp = new int[nums.length + 1][target + 1];

        // 初始化状态
        dp[0][0] = 1;

        // 动态规划计算方法数
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        int result = solution.findTargetSumWays(nums, S);
        System.out.println(result);
    }
}

