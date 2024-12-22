class Solution {

    // 1. MEMOIZATION APPROACH 
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1, grid, dp);
    }
    public int helper(int i, int j, int[][] grid, int[][] dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int) Math.pow(10, 9);
        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + helper(i-1, j, grid, dp);
        int left = grid[i][j] + helper(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    // 2. TABULATION APPROACH
    // public int minPathSum(int[][] grid){
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][] dp = new int[m][n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i==0 && j==0){
    //                 dp[i][j] = grid[0][0];
    //             }
    //             else{
    //                 int up = grid[i][j];
    //                 if(i>0) up += dp[i-1][j];
    //                 else up += (int) Math.pow(10,9);

    //                 int left = grid[i][j];
    //                 if(j>0) left += dp[i][j-1];
    //                 else left += (int) Math.pow(10,9);

    //                 dp[i][j] = Math.min(up,left);
    //             }
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }

    // 3. SPACE OPTIMIZATION APPROACH
//     public int minPathSum(int[][] grid){
//         int m = grid.length;
//         int n = grid[0].length;
//         int[] prev = new int[n];

//         for(int i=0;i<m;i++){
//             int[] temp = new int[n];
//             for(int j=0;j<n;j++){
//                 if(i==0 && j==0) temp[j] = grid[i][j];
//                 else{
//                     int up = grid[i][j];
//                     if(i>0) up += prev[j];
//                     else up += (int) Math.pow(10,9);

//                     int left = grid[i][j];
//                     if(j>0) left += temp[j-1];
//                     else left += (int) Math.pow(10,9);

//                     temp[j] = Math.min(up,left);
//                 }
//             }
//             prev = temp;
//         }
//         return prev[n-1];
//     }
}