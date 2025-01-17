class Solution {
    // 1. Memoization Approach
    public int maxProfit(int cap, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][cap + 1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(prices, 0, 0, cap, dp);
    }
    public int helper(int[] prices, int ind, int buy, int cap, int[][][] dp){
        int n = prices.length;

        if(ind == n || cap==0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        int profit=0;

        if(buy == 0){
            profit = Math.max(0 + helper(prices, ind+1, 0, cap, dp),
            -prices[ind] + helper(prices, ind+1, 1, cap, dp));
        }
        if(buy == 1){
            profit = Math.max(0 + helper(prices, ind+1, 1, cap, dp),
            prices[ind] + helper(prices, ind+1, 0, cap - 1, dp));
        }
        return dp[ind][buy][cap] = profit;
    }
}