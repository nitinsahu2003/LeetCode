class Solution {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums,0,nums.length-1);
    }
    private int mergeAndCount(int[] nums, int low, int mid, int high){
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2*(long)nums[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
        int[] temp=new int[high-low+1];
        int k=0, left=low, r=mid+1;
        while(left<=mid && r<=high){
            if(nums[left]<=nums[r]) temp[k++]=nums[left++];
            else temp[k++]=nums[r++];
        }
        while(left<=mid){
            temp[k++]=nums[left++];
        } 
        while(r<=high){
            temp[k++]=nums[r++];
        } 
        for(int i=low;i<=high;i++){
           nums[i]=temp[i-low];
        }
        return count;
    }
    private int mergeSortAndCount(int[] nums, int low, int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=mergeSortAndCount(nums,low,mid);
        count+=mergeSortAndCount(nums,mid+1,high);
        count+=mergeAndCount(nums,low,mid,high);
        return count;
    }
}