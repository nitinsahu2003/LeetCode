class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int prev=0, curr=0;
        for(int i=0;i<nums.length;i++){
            int sum=Math.max(curr,prev+nums[i]);
            prev=curr;
            curr=sum;
        }
        return curr;
    }
}