class Solution {
    public int findPeakElement(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                idx=i+1;
            }
        }
        return idx;
    }
}