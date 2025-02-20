class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] ct = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(ct, 1);

        int max = 1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev] < nums[i] && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    ct[i] = ct[prev];
                }else if(nums[prev] < nums[i] && dp[prev] + 1 == dp[i]){
                    ct[i] += ct[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }
        int nos = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == max){
                nos += ct[i];
            }           
        }
        return nos;
    }
}