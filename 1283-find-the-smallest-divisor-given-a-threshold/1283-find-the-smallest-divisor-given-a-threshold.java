class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold) return -1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int low=1, high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumByDiv(nums,mid)<=threshold) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int sumByDiv(int[] nums, int div){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += (nums[i] + div - 1) / div;
        }
        return sum;
    }
}