class Solution {
    // 1. MEMOIZATION APPROACH
    // Time Complexity: O(N*K) + O(N)
    // Space Complexity: O(N*K) + O(N)
    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     int n = nums.length;
    //     for(int i=0;i<n;i++){
    //         sum += nums[i];
    //     }
    //     if(sum % 2 ==1) return false;
    //         int k = sum / 2;
    //         int[][] dp = new int[n][k+1];
    //         for(int[] row : dp){
    //             Arrays.fill(row, -1);
    //     }
    //     return helper(n-1, k, dp, nums);
    // }
    // public boolean helper(int ind, int target, int[][] dp, int[] nums){
    //     if(target==0) return true;
    //     if(ind==0) return nums[ind] == target;
    //     if(dp[ind][target] != -1){
    //         if(dp[ind][target] == 0) return false;
    //         else return true;
    //     }

    //     boolean nonPick = helper(ind-1, target, dp, nums);
    //     boolean pick = false;
    //     if(nums[ind] <= target) pick = helper(ind-1, target - nums[ind], dp, nums);

    //     if(pick || nonPick){
    //         dp[ind][target] = 1;
    //         return true;
    //     }else{
    //         dp[ind][target] = 0;
    //         return false;
    //     }
    // }

    // 2. TABULATION APPROACH
    // Time Complexity: O(N*K) + O(N)
    // Space Complexity: O(N*K) 
    // public boolean canPartition(int[] nums){
    //     int n = nums.length;
    //     int sum = 0;
    //     for(int i=0;i<n;i++){
    //         sum += nums[i];
    //     }
    //     if(sum % 2 == 1) return false;
    //     int k = sum / 2;
    //     boolean[][] dp = new boolean[n][k+1];
    //     for(int i=0;i<n;i++){
    //         dp[i][0] = true;
    //     }
    //     if(nums[0] <= k) dp[0][nums[0]] = true;
    //     for(int i=1;i<n;i++){
    //         for(int target=1; target<=k;target++){
    //             boolean notPick = dp[i-1][target];
    //             boolean pick = false;
    //             if(nums[i]<=target) pick = dp[i-1][target - nums[i]];

    //             dp[i][target] = pick || notPick;
    //         }
    //     }
    //     return dp[n-1][k];
    // }

    // 3. SPACE OPTIMIZATION APPROACH
    public boolean canPartition(int[] nums){
        int n =nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        int k = sum / 2;
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(nums[0] <= k) prev[nums[0]] = true;
        for(int i=1;i<n;i++){
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target=1;target<=k;target++){
                boolean notPick = prev[target];
                boolean pick = false;
                if(nums[i] <= target) pick = prev[target-nums[i]];

                curr[target] = pick || notPick;
            }
            prev = curr;
        }
        return prev[k];
    }
}