class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(s1, s2, m-1, n-1, dp);
    }
    public int helper(String s1, String s2, int i1, int i2, int[][] dp){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];
        if(s1.charAt(i1) == s2.charAt(i2)) return dp[i1][i2] = 1 + helper(s1, s2, i1-1, i2-1, dp);
        else{
            int max1 = helper(s1, s2, i1, i2-1, dp);
            int max2 = helper(s1, s2, i1-1, i2, dp);
            return dp[i1][i2] = Math.max(max1, max2);
        } 
    }
}