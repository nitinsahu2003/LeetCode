class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n==0 || k==0) return 0;
        int[][][] dp = new int[n+1][2][k+1];

        // for (int ind = 0; ind <= n; ind++) {
        //     for (int buy = 0; buy <= 1; buy++) {
        //         dp[ind][buy][0] = 0;
        //     }
        // }
        // for (int buy = 0; buy <= 1; buy++) {
        //     for (int cap = 0; cap <= k; cap++) {
        //         dp[n][buy][cap] = 0;
        //     }
        // }

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy == 0){
                        dp[ind][buy][cap] = Math.max(0 + dp[ind+1][0][cap],
                        -prices[ind] + dp[ind+1][1][cap]);
                    }
                    else{
                        dp[ind][buy][cap] = Math.max(0 + dp[ind+1][1][cap],
                        prices[ind] + dp[ind+1][0][cap - 1]);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}