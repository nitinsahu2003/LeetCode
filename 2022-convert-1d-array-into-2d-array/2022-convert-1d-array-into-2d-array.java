class Solution {
    public int[][] construct2DArray(int[] original, int r, int c) {
        if(original.length!=r*c){
            return new int[0][0]; 
        }
        int k=0;
        int[][] newMatrix=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                newMatrix[i][j]=original[k++];
            }
        }
        return newMatrix;
    }
}