class Solution {
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum - target) < 0 || (sum - target) % 2 == 1) return 0;
        return helper(nums, (sum - target) / 2);
    }
    public int helper(int[] nums, int tar){
        int n = nums.length;
        int[] prev = new int[tar+1];

        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if(nums[0] != 0 && nums[0] <= tar) prev[nums[0]] = 1;

        for(int i=1;i<n;i++){
            int[] curr = new int[tar+1];
            for(int target=0;target<=tar;target++){
                int notPick = prev[target];
                int pick = 0;
                if(nums[i] <= target) pick = prev[target - nums[i]];

                curr[target] = (pick + notPick);
            }
            prev = curr;
        }
        return prev[tar];
    } 
}