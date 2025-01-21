class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int prevIdx=ind-1;prevIdx>=-1;prevIdx--){
                int notTake = dp[ind + 1][prevIdx + 1];
                int take = 0;
                if(prevIdx == -1 || nums[ind] > nums[prevIdx]){
                    take = 1 + dp[ind + 1][ind+1];
                }
                dp[ind][prevIdx+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}