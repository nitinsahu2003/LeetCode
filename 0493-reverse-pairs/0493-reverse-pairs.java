class Solution {
    public int reversePairs(int[] nums) {
       return mergeSort(nums,0,nums.length-1);
    }
    private void merge(int[] nums, int low, int mid, int high){
        List<Integer> ans=new ArrayList<>();
        int left=low, right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){    //merge left half
                ans.add(nums[left]);
                left++;
            }else{
                ans.add(nums[right]);   //merge right half
                right++;
            }
        }
        // merge remaining elements
        while(left<=mid){
            ans.add(nums[left]);
            left++;
        }
        while(right<=high){
            ans.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i]=ans.get(i-low);
        }
    }
    private int mergeSort(int[] nums, int low ,int high){
        int count=0;
        if(low>=high) return count;
        int mid=(low+high)/2;
        count+=mergeSort(nums,low,mid);     //sorting left half
        count+=mergeSort(nums,mid+1,high);  //sorting right half
        count+=countPairs(nums,low,mid,high);   //adding number of pairs to result
        merge(nums,low,mid,high);   //merging the halves
        return count;
    }
    private int countPairs(int[] nums, int low, int mid, int high){
         int right=mid+1;
         int count=0;
         for(int i=low;i<=mid;i++){
             while(right<=high && (long)nums[i]>2L*nums[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
         return count;
    }
}