class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int num : nums){
            sum += num;
        }
        long leftSum = 0;
        int count = 0;

        for(int i=0;i<n-1;i++){
            leftSum += nums[i];
            long rightSum = sum - leftSum;

            if(leftSum >= rightSum) count++;
        }
        return count;
    }
}