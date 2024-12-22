class Solution {
    private int[][] dp;

    // 1. Memoization approach 
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(0, 0, n, triangle);
    }
    private int helper(int i, int j, int n, List<List<Integer>> triangle){
        if(i == n-1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];

        int down = helper(i+1, j, n, triangle);
        int diagonal = helper(i+1, j+1, n, triangle);

        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
        return dp[i][j];
    }
}