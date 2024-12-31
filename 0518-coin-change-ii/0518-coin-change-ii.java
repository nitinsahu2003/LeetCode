class Solution {
    // 1. Memoization Approach
    // Time complexity - O(N*T)
    // Space complexity - O(N*T) + O(N)
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n][amount + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return helper(n - 1, amount, coins, dp);
        }

        public int helper(int i, int amount, int[] coins, int[][] dp) {
            if (i == 0) {
                if (amount % coins[0] == 0)
                    return 1;
                else
                    return 0;
            }
            if (dp[i][amount] != -1)
                return dp[i][amount];
            int notPick = helper(i - 1, amount, coins, dp);
            int pick = 0;
            if (coins[i] <= amount)
                pick = helper(i, amount - coins[i], coins, dp);
            return dp[i][amount] = pick + notPick;
        }
    }
    // 2. Tabulation Approach
    // Time complexity - O(N*T)
    // Space complexity - O(N*T)
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0) dp[0][i] = 1;
        }

        for(int i=1;i<n;i++){
            for(int target=0;target<=amount;target++){
            int notPick = dp[i-1][target];
            int pick = 0;
            if(coins[i] <= target) pick = dp[i][target - coins[i]];
            dp[i][target] = pick + notPick;
            }
        }
        return dp[n-1][amount];
    }
    // 3. Space Optimisation Approach
    // Time complexity - O(N*T)
    // Space complexity - O(T)
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0) prev[i] = 1;
        }

        for(int i=1;i<n;i++){
            int[] curr = new int[amount+1];
            for(int target=0;target<=amount;target++){
                int notPick = prev[target];
                int pick = 0;
                if(coins[i] <= target) pick = curr[target - coins[i]];
                curr[target] = pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}
