class Solution {

    // 1. MEMOIZATION APPROACH
    // Time Complexity: O(M*N)
    //Space Complexity: O(N) + O(N*M)
     public int minFallingPathSum(int[][] matrix) {
         int m = matrix.length;
         int n = matrix[0].length;
         int[][] dp = new int[m][n];
         for(int[] row : dp){
             Arrays.fill(row, -1);
         }
         int min = Integer.MAX_VALUE;
         for(int j=0;j<n;j++){
             int ans = helper(m-1, j, m, n, dp, matrix);
             min = Math.min(min, ans);
         }
         return min;
     }
     public int helper(int i, int j, int m, int n, int[][] dp, int[][] matrix){
         if(j<0 || j>=n) return (int) Math.pow(10,9);
         if(i==0) return matrix[0][j];
         if(dp[i][j] != -1) return dp[i][j];

         int up = matrix[i][j] + helper(i-1, j, m, n, dp, matrix);
         int left = matrix[i][j] + helper(i-1, j-1, m, n, dp, matrix);
         int right = matrix[i][j] + helper(i-1, j+1, m, n, dp, matrix);

         return dp[i][j] = Math.min(up, Math.min(left, right));
     }

    // 2. TABULATION APPROACH
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
     public int minFallingPathSum(int[][] matrix){
         int m = matrix.length;
         int n = matrix[0].length;

         int[][] dp = new int[m][n];

         for(int j=0;j<n;j++){
             dp[0][j] = matrix[0][j];
         }
         for(int i=1;i<m;i++){
             for(int j=0;j<n;j++){
                 int up = matrix[i][j] + dp[i-1][j];

                 int left = matrix[i][j];
                 if(j-1 >= 0) left += dp[i-1][j-1];
                 else left += (int) Math.pow(10,9);

                 int right = matrix[i][j];
                 if(j+1 < n) right += dp[i-1][j+1];
                 else right += (int) Math.pow(10,9);

                 dp[i][j] = Math.min(up, Math.min(left, right));
             } 
         }
         int min = Integer.MAX_VALUE;
          for(int j=0;j<n;j++){
             min = Math.min(min, dp[m-1][j]);
         }
         return min;
     }

    // 3. Space optimization approach
    // Time Complexity: O(N*M)
    // Space Complexity: O(M)
    public int minFallingPathSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = Arrays.copyOf(matrix[0], n);

        for(int i=1;i<m;i++){
            int[] curr = new int[n];
            for(int j=0;j<n;j++){
                int up = prev[j];
                int left = (j>0) ? prev[j-1] : Integer.MAX_VALUE;
                int right = (j<n-1) ? prev[j+1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
            prev = curr;
        }
        int min = Integer.MAX_VALUE;
        for(int val : prev){
            min = Math.min(min, val);
        }
        return min;
    }
}
