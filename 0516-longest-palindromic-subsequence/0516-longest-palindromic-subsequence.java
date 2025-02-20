class Solution {

    // Tabulation Approach
        public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return helper(s, reversed);
    }

    public int helper(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i1 = 1; i1 <= m; i1++) {
            for (int i2 = 1; i2 <= n; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = Math.max(dp[i1][i2 - 1], dp[i1 - 1][i2]);
            }
        }
        return dp[m][n];
    }

    // Space Optimization Approach
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return helper(s, reversed);
    }
    public int helper(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];

        for(int ind1=1;ind1<=m;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1)) curr[ind2] = 1 + prev[ind2-1];
                else curr[ind2] = Math.max(prev[ind2], curr[ind2-1]);
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}
