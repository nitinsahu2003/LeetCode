class Solution {
    static int mod = (int) (Math.pow(10,9)+7);
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum-target)<0 || (sum - target) %2==1) return 0;
        return helper(nums, (sum - target) / 2);
    }
    public int helper(int[] nums, int tar){
        int n = nums.length;
        int[][] dp = new int[n][tar+1];
        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(nums[0] != 0 && nums[0] <= tar) dp[0][nums[0]] = 1;
        for(int i=1;i<n;i++){
            for(int target=0;target<=tar;target++){
                int notPick = dp[i-1][target];
                int pick = 0;
                 if(nums[i] <= target) pick = dp[i-1][target-nums[i]];

                 dp[i][target] = (pick + notPick) % mod;
            }
        }
        return dp[n-1][tar];
    }
}