class Solution {
    public int splitArray(int[] nums, int k) {
        int low=nums[0], high=0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            int partitions=countPartitions(nums,mid);
            if(partitions>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int countPartitions(int[] nums,int maxSum){
        int partitions=1;
        long subArraySum=0;
        for(int i=0;i<nums.length;i++){
            if(subArraySum+nums[i]<=maxSum) subArraySum+=nums[i];
            else {
                partitions++;
                subArraySum=nums[i];
            }
        }
        return partitions;
    }
}