class Solution {
    public List<Integer> findPeaks(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        
        for(int i=1;i<nums.length-1;i++){
            boolean leftPeak=(nums[i]>nums[i-1]);
            boolean rightPeak=(nums[i]>nums[i+1]);
            if(leftPeak && rightPeak) ans.add(i);
        }
        return ans;
    }
}