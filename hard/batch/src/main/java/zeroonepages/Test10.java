package zeroonepages;

public class Test10 {
    public static void main(String[] args) {
        int[] dp ={3,3,5,0,0,3,1,4};
        int i = maxProfit(2,dp);

        System.out.println(i);
    }
    public static  int maxProfit(int k, int[] prices) {
        int m = prices.length;
        int[][] dp = new int[m][2 * k + 1];
        for(int i = 1 ;i < 2 * k;  i+=2){
            dp[0][i] = - prices[0];
        }
        for(int i = 1;i < m;i++){
            for(int j = 0 ; j < 2 * k;j+=2){
                //不持有   i  + 1,   买入 :
                dp[i][j + 1] = Math.max(dp[i- 1][j + 1],dp[i -1][j+ 2] - prices[i]);
                //持有
                dp[i][j + 2] = Math.max(dp[i -1][j + 2],dp[i - 1][j + 1] + prices[i]);
            }
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2* k; j++) {
                System.out.print(dp[i][2*k] + "\t");
            }
            System.out.print("\n");
        }
        return dp[m - 1][2 * k];
    }

}
