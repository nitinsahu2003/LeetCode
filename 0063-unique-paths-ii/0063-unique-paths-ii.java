class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        if(mat[0][0]==1 || mat[m-1][n-1]==1) return 0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1) dp[j]=0;
                else if(j>0) dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
    }
}