class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[]=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
            result[i]=nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}