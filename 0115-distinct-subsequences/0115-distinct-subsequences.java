class Solution {
    public int numDistinct(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(s1, s2, m, n, dp);
    }
    public int helper(String s1, String s2, int i, int j, int[][] dp){
        if(j==0) return 1;
        if(i==0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            int notPick = helper(s1, s2, i-1, j-1, dp);
            int pick = helper(s1, s2, i-1, j, dp);
            return dp[i][j] = pick + notPick;
        }else{
            return dp[i][j] = helper(s1, s2, i-1, j, dp);
        }     
    }
}