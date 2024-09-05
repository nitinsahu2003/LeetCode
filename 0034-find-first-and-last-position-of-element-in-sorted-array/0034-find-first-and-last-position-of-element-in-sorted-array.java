class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        result[0]=findFirstPosition(nums,target);
        result[1]=findLastPosition(nums,target);
        return result;
    }
    private int findFirstPosition(int[] nums, int target){
        int firstPosition=-1;
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                firstPosition=mid;
                right=mid-1;
            }else if(nums[mid]<target) left=mid+1;
            else right=mid-1; 
        }
        return firstPosition;
    }
    private int findLastPosition(int[] nums, int target){
        int lastPosition=-1;
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                lastPosition=mid;
                left=mid+1;
            }else if(nums[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return lastPosition;
    } 
}