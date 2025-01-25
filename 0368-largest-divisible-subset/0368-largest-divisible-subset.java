class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[n];
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            List<Integer> subset = helper(nums, i, dp);
            if(subset.size() > result.size()) result = subset;
        }
        return result;
     }
    public List<Integer> helper(int[] nums, int idx, List<Integer>[] dp){
        if(dp[idx] != null) return dp[idx];
        List<Integer> maxSubset = new ArrayList<>();
        for(int i=idx+1;i<nums.length;i++){
            if(nums[i] % nums[idx] == 0){
                List<Integer> subset = helper(nums, i, dp);
                if(subset.size() > maxSubset.size()) maxSubset = subset;
            }
        }
        maxSubset = new ArrayList<>(maxSubset);
        maxSubset.add(0, nums[idx]);
        dp[idx] = maxSubset;
        return maxSubset;
    }
}