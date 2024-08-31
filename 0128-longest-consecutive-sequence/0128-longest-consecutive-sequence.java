class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int result=0;
        for(int i=0;i<nums.length;i++){
            int count=1;
            int curr=nums[i];
            while(i+1<nums.length && nums[i+1]==curr+1){
                count++;
                curr++;
                i++;
                while(i+1 < nums.length && nums[i+1]==curr){
                    i++;
                }
            }
            result=Math.max(count,result);
        }
        return result;
    }
}