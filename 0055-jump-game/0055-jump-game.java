class Solution {
    public boolean canJump(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            if(i>total) return false;
            total=Math.max(total,i+nums[i]);
        }
        return true;
    }
}