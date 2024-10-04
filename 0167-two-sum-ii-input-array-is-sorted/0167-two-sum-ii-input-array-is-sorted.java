class Solution {
    public int[] twoSum(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while(low<high){
            int result=nums[low]+nums[high];
            if(result==target) return new int[]{low+1,high+1};
            if(result<target) low++;
            else high--;
        }
        return new int[]{};
    }
}