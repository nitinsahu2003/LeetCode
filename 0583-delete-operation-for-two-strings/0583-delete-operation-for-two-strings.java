class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int k = helper(word1, word2);
        return (n-k) + (m-k);
    }
    public int helper(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i=0;i<=m;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=m;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(word1.charAt(ind1-1) == word2.charAt(ind2-1)) dp[ind1][ind2] = 1+dp[ind1-1][ind2-1];
                else dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
            }
        }
        return dp[m][n];
    }
}