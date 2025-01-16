class Solution {
    // 3. Space optimization Approach
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap <= 2; cap++) {
                    if (buy == 0) {
                        curr[buy][cap] = Math.max(0 + ahead[0][cap],
                        -prices[ind] + ahead[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(0 + ahead[1][cap],
                        cap > 0 ? prices[ind] + ahead[0][cap - 1] : 0);
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    ahead[i][j] = curr[i][j];
                }
            }
        }
        return ahead[0][2];
    }
}