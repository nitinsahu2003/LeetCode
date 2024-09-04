class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
       int s1=(n*(n+1))/2; // sum of all the numbers in the given range
       int s2=0; // sum of all the numbers of araay
       for(int i=0;i<n;i++){
        s2+=nums[i];
       }
       int result=s1-s2;
       return result;
    }
}