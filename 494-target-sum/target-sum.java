class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if((sum - target) < 0) return 0;
        if((sum - target) % 2 == 1) return 0;
        int s2 = (sum - target) / 2;
        int[][] dp = new int[n][s2+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(n-1, s2, nums, dp);
    }
    public int helper(int i, int target, int[] nums, int[][] dp){
        if(i == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || target == nums[0]) return 1;
            else return 0;
        }
        if(dp[i][target] != -1) return dp[i][target];
        int notPick = helper(i-1, target, nums, dp);
        int pick = 0;
        if(nums[i] <= target) pick = helper(i-1, target - nums[i], nums, dp);
        
        return dp[i][target] = (pick + notPick);
    }
}