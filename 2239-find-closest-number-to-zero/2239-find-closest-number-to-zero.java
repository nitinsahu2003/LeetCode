class Solution {
    public int findClosestNumber(int[] nums) {
        int closestNum=nums[0];

        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])<Math.abs(closestNum)){
                closestNum=nums[i];
            }else if(Math.abs(nums[i])==Math.abs(closestNum) && nums[i]>closestNum){
                closestNum=nums[i];
            }
        }
            return closestNum;
    }
}