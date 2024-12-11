class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int left=(j>0) ? matrix[i-1][j-1]:Integer.MAX_VALUE;
                int up=matrix[i-1][j];
                int right=(j<n-1) ? matrix[i-1][j+1] : Integer.MAX_VALUE;

                matrix[i][j]+=Math.min(left,Math.min(up,right));
            }
        }
        int result = Integer.MAX_VALUE;
        for(int value : matrix[m-1]){
            result=Math.min(result,value);
        }
        return result;
    }
}