class Solution {
    // This question follows up left approach


    // 1. MEMOIZATION APPROACH- it gives 0ms time complexity
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for(int[] row : dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return helper(m-1, n-1, dp);
    // }
    // public int helper(int m, int n, int[][] dp){
    //     if(m==0 && n==0) return 1;
    //     if(m<0 || n<0) return 0;
    //     if(dp[m][n] != -1) return dp[m][n];

    //     int up = helper(m-1, n , dp);
    //     int left = helper(m, n-1, dp);

    //     return dp[m][n] = up + left;
    // }

    // 2. Tabulation approach - it gives 1ms time complexity
    // public int uniquePaths(int m, int n){
    //     int[][] dp = new int[m][n];
    //     for(int[] row : dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return helper(m, n, dp);
    // }
    // public int helper(int m, int n, int[][] dp){
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i == 0 && j == 0){
    //                 dp[i][j] = 1;
    //                 continue;
    //             }
    //             int up=0, left=0;
    //             if(i>0) up = dp[i-1][j];
    //             if(j>0) left = dp[i][j-1];
    //             dp[i][j] = up + left;
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }

    // 3. Space optimization approach
    public int uniquePaths(int m, int n){
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i == 0 && j==0){
                    temp[j] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if(i>0) up = prev[j];
                if(j>0) left = temp[j-1];

                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}