class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0]; //array with single element
        else if(nums.length==2) return Math.max(nums[0],nums[1]);
        else return Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1)); //rob house excluding the first house or last house
    }
    private int helper(int[] nums,int start, int end){
        int prev1=0, prev2=0;
        for(int i=start;i<=end;i++){
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}