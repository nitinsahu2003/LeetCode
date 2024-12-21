class Solution {
    // 1. MEMOIZATION APPROACH - with O(n*m) time complexity
    public int uniquePathsWithObstacles(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1, dp, maze);
    }
    public int helper(int i, int j, int[][] dp, int[][] maze){
        if(i >= 0 && j >= 0 && maze[i][j] == 1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int up = helper(i-1, j, dp, maze);
        int left = helper(i, j-1, dp, maze);
        return dp[i][j] = up + left;
    }

    // 2. TABULATION APPROACH - 1ms time complexity
//     public int uniquePathsWithObstacles(int[][] maze){
//         int m = maze.length;
//         int n = maze[0].length;
//         int[][] dp = new int[m][n];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
//         return helper(m, n, dp, maze);
//     }
//     public int helper(int m, int n, int[][] dp, int[][] maze){
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i >= 0 && j >= 0 && maze[i][j] == 1){
//                     dp[i][j] = 0;
//                     continue;
//                 }
//                 if(i == 0 && j == 0){
//                     dp[i][j] = 1;
//                     continue;
//                 }
//                 int up = 0, left = 0;
//                 if(i>0) up = dp[i-1][j];
//                 if(j>0) left = dp[i][j-1];

//                 dp[i][j] = up + left;  
//             }
//         }
//         return dp[m-1][n-1];
//     }

    // 3. Space optimization approach
//     public int uniquePathsWithObstacles(int[][] maze){
//         int m = maze.length;
//         int n = maze[0].length;
//         int[] prev = new int[m];

//         for(int i=0;i<m;i++){
//             int[] temp = new int[n];
//             for(int j=0;j<n;j++){
//                 if(i >= 0 && j>= 0 && maze[i][j] == 1){
//                     temp[j] = 0;
//                     continue;
//                 }
//                 if(i == 0 && j == 0){
//                     temp[j] = 1;
//                     continue;
//                 }

//                 int up = 0, left = 0;
//                 if(i > 0) up = prev[j];
//                 if(j > 0) left = temp[j-1];
                 
//                 temp[j] = up + left;
//             }
//             prev = temp;
//         }
//         return prev[n-1];
//     }
}