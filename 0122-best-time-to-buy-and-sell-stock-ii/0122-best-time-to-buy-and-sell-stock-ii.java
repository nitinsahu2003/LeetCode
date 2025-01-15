class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 1, dp);
    }
    public int helper(int[] prices, int day, int canBuy, int[][] dp){
        if(day >= prices.length) return 0;
        if(dp[day][canBuy] != -1) return dp[day][canBuy];
        int idle = helper(prices, day+1, canBuy, dp);

        if(canBuy == 1){
            int buy = helper(prices, day+1, 0, dp) - prices[day];
            dp[day][canBuy] = Math.max(buy, idle);
        }else{
            int sell = helper(prices, day+1, 1, dp) + prices[day];
            dp[day][canBuy] = Math.max(sell, idle);
        }
        return dp[day][canBuy];
    }
}