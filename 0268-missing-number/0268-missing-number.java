class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
        int arrSum=0;

        for(int num : nums){
            arrSum+=num;
        }
        return sum-arrSum;
        
    }
}