class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(s1, s2, m - 1, n - 1, dp);
    }
    public int helper(String s1, String s2, int ind1, int ind2, int[][] dp){
        if(ind1 < 0) return ind2 + 1;
        if(ind2 < 0) return ind1 + 1;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = helper(s1, s2, ind1 - 1, ind2 - 1, dp);
        }else{
            return dp[ind1][ind2] = 1 +  Math.min(helper(s1, s2, ind1 - 1, ind2 - 1, dp), 
            Math.min(helper(s1, s2, ind1 - 1, ind2, dp), helper(s1, s2, ind1, ind2 - 1, dp)));
        }
    }
}