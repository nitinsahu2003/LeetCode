class Solution {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        int min=Integer.MAX_VALUE; // to store result
        while(low<=high){
            int mid=(low+high)/2;  //finding middle
            if(nums[low]<nums[mid]){    //searching in right half
                min=Math.min(min,nums[low]);
                low=mid+1;
            }else if(nums[mid]<nums[high]){     // searching in left half
                min=Math.min(min,nums[mid]);
                high=mid-1;
            }else{
                min=Math.min(min,nums[low]);
                low=low+1;
            }
        }
        return min;
    }
}