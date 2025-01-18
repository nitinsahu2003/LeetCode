class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 0, dp);
    }
    public int helper(int[] prices, int ind, int buy, int[][] dp){
        int n = prices.length;
        if(ind >= n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(0 + helper(prices, ind+1, 0, dp),
            -prices[ind] + helper(prices, ind+1, 1, dp));
        }
        if(buy == 1){
            profit = Math.max(helper(prices, ind+1, 1, dp),
            prices[ind] + helper(prices, ind+2, 0, dp)); // +2 is because you can't buy next day after selling the stock.
        }
        return dp[ind][buy] = profit;
    }
}