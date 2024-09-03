class Solution {
    public int majorityElement(int[] nums) {
        int result=0;
        int count1=0, count2=0;
        int elmnt1=0, elmnt2=1;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && elmnt2!=nums[i]){
                count1=1;
                elmnt1=nums[i];
            }else if(count2==0 && elmnt1!=nums[i]){
                count2=1;
                elmnt2=nums[i];
            }else if(elmnt1==nums[i]){
                count1++;
            }else if(elmnt2==nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0; count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==elmnt1) count1++;
            if(nums[i]==elmnt2) count2++;
        }
        int min=(int)(nums.length/2)+1;
        if(count1>=min) result= elmnt1;
        if(count2>=min) result= elmnt2;
        return result;
    }
}