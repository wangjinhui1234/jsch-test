package zeroonepages;

public class money {
    public static void main(String[] args) {
        int[] coins ={1,2,5};
        int change = change(5, coins);
        System.out.println(change);
    }
    public static int change(int amount, int[] coins) {
        int num = coins.length;
        int[] dp = new int[amount + 1];

        //初始化dp数组
        dp[0] = 1;
        //先物品在背包  只会出现1，2 不会出现2 ，1
        for (int i = 0; i <num;i++ ){
            for(int j = amount; j >= coins[i];j++ ){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
