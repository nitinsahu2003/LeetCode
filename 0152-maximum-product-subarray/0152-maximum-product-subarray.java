class Solution {
    public int maxProduct(int[] nums) {
        int pre=1, post=1;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(post==0) post=1;
            pre*=nums[i];
            post*=nums[nums.length-i-1];
            result=Math.max(result,Math.max(pre,post));
        }
        return result;
    }
}