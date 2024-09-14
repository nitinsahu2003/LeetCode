class Solution {
    public int longestSubarray(int[] nums) {
        int maxElement=nums[0];
        for(int i=0;i<nums.length;i++){
            maxElement=Math.max(maxElement,nums[i]);
        }
        int currLength=0;
        int longestSub=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxElement){
                currLength++;
                longestSub=Math.max(longestSub,currLength);
            }else{
                currLength=0;
            }
        }
        return longestSub;
    }
}