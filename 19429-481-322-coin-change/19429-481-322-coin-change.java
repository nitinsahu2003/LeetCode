class Solution {
    // 1. TABULATION APPROACH
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = helper(coins, n-1, amount, dp);
        if(ans >= (int) Math.pow(10,9)) return -1;
        return ans;
    }
    public int helper(int[] coins, int i, int amount, int[][] dp){
        if(i == 0){
            if(amount % coins[0] == 0) return amount / coins[0];
            else return (int) Math.pow(10,9);
        }
        if(dp[i][amount] != -1) return dp[i][amount];

        int notPick = 0 + helper(coins, i - 1, amount, dp);
        int pick = (int) Math.pow(10,9);

        if(coins[i] <= amount) pick = 1 + helper(coins, i, amount - coins[i], dp);

        return dp[i][amount] = Math.min(pick, notPick);
    }
}