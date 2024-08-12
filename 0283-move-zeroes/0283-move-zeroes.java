class Solution {
    public void moveZeroes(int[] nums) {
        int idx=0;
        //Move all non zero element to first
        for(int num:nums){
            if(num != 0){
                nums[idx++]=num;
            }
        }
        // fill the rest array with 0's
        while(idx<nums.length){
            nums[idx++]=0;
        }
    }
}