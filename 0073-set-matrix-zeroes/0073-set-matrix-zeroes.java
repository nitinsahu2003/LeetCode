class Solution {
    public void setZeroes(int[][] matrix) {
        int[] newRow=new int[matrix.length];
        int[] newCol=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    newRow[i]=1;
                    newCol[j]=1;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(newRow[i]==1 || newCol[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}