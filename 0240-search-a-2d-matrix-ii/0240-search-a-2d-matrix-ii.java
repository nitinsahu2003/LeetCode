class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=0, cols=matrix[0].length-1;
        while(rows<matrix.length && cols>=0){
            if(matrix[rows][cols]==target) return true;
            else if(matrix[rows][cols]<target) rows++;
            else cols--;
        }
        return false;
    }
}