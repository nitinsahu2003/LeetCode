class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(nums, 0, -1, dp);
    }
    public int helper(int[] nums, int ind, int prevIdx, int[][] dp){
        int n = nums.length;
        if(ind == n) return 0;

        if(dp[ind][prevIdx + 1] != -1) return dp[ind][prevIdx + 1];
        
        int notTake = 0 + helper(nums, ind+1, prevIdx, dp);
        int take = 0;
        if(prevIdx == -1 || nums[ind] > nums[prevIdx]) take = 1 + helper(nums, ind+1, ind, dp);

        dp[ind][prevIdx + 1] = Math.max(take, notTake);
        return dp[ind][prevIdx+1];
    }
}