class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // If k is greater than half the number of days, it's equivalent to unlimited transactions
        if (k >= prices.length / 2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // DP arrays
        int[][] dp = new int[k + 1][prices.length];

        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < prices.length; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[k][prices.length - 1];
    }
}
