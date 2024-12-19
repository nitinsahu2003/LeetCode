class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0],nums[1]);
        else return Math.max(helper(nums, 0 , nums.length-2), helper(nums, 1, nums.length-1));
    }

    private int helper(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <=end; i++) {
            int pick = nums[i] + prev2;
            int nonPick = prev1;
            int curr = Math.max(pick, nonPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}