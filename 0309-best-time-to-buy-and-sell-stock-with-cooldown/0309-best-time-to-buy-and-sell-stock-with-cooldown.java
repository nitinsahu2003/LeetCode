class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        int profit = 0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy==0){
                   profit = Math.max(dp[ind+1][0],
                   -prices[ind] + dp[ind+1][1]);
                }
                if(buy==1){
                    profit = Math.max(dp[ind+1][1],
                    prices[ind] + dp[ind+2][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }
}