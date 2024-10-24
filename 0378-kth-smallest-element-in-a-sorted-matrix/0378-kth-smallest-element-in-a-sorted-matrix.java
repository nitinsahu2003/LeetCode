class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0], high=matrix[n-1][n-1];
        while(low<high){
            int mid=low+(high-low)/2;   //calculating mid
            int count=countLessEqual(matrix,mid,n);
            if(count<k) low=mid+1;  //shifting the pointer according to condition
            else high=mid;
        }
        return low;
    }
    private int countLessEqual(int[][] matrix, int target, int n){
        int count=0;
        int rows=n-1, cols=0;   //row=bottom left corner, col=first element
        while(rows>=0 && cols<n){
            if(matrix[rows][cols]<=target){
                count+=(rows+1);
                cols++;
            }else{
                rows--;
            }
        }
        return count;
    }
}