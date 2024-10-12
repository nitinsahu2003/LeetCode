class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows= matrix.length, cols=matrix[0].length;
        int low=0, high=rows*cols-1;  // rows*cols-1 means the total elements in a matrix

        if(matrix.length==0 || matrix[0].length==0) return false;   // base condition
        while(low<=high){
            int mid=(low+high)/2;
            int midElement=matrix[mid/cols][mid%cols];  //  mid/cols=row no. & mid%cols=col no.
            if(midElement==target) return true;
            else if(midElement<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}