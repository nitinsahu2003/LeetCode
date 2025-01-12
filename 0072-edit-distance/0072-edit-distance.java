class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=n;i++){
            dp[0][i] = i;
        }

        for(int ind1=1;ind1<=m;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)){
                    dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1];
                }else{
                    dp[ind1][ind2] = 1 + Math.min(dp[ind1-1][ind2-1],
                    Math.min(dp[ind1-1][ind2], dp[ind1][ind2-1]));
                }
            }
        }
        return dp[m][n];
    }
}