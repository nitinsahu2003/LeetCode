class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int jump=0;
        int currEnd=0;
        int farthest=0;

        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,i+nums[i]);

            if(i==currEnd){
                jump++;
                currEnd=farthest;
            }
            if(currEnd>=nums.length-1){
                break;
            }        
        }
        return jump;
    }
}