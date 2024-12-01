package zeroonepages;

public class Test09 {

    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
        int i = maxProfit(price);
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {
        int m =  prices.length;
        //dp[i][0] 持有股最大金额   dp[i][1] 不持有股最大金额
        int[][] dp = new int[m + 1][m + 1];

        dp[0][1] = 0;
        dp[0][0] = -prices[0];
        for (int i = 1; i <m;i++ ){
            dp[i][0] =Math.max(dp[i -1][0] ,-prices[i]);
            dp[i][1] = Math.max(dp[i -1][1], dp[i -1][0] + prices[i]);
        }
        for (int i = 0; i < m; i++) {
            System.out.print(dp[i][0]+"\t");
        }
        System.out.println("-----------");
        for (int i = 0; i < m; i++) {
            System.out.print(dp[i][1]+"\t");
        }
        return  Math.max(dp[m - 1][0],dp[m -1][1]);
    }
}
