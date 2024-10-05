class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1, high=findMax(piles);
        while(low<high){
            int mid=(low+high)/2;
            if(calculateTotalHours(piles,mid)<=h) high=mid;
            else low=mid+1;
        }
        return low;
    }
    public int findMax(int[] piles){
        int max=0;
        for(int pile:piles){
            max=Math.max(pile,max);
        }
        return max;
    }
    public int calculateTotalHours(int[] piles, int k){
        int total=0;
        for(int pile:piles){
            total+=(pile+k-1)/k;
        }
        return total;
    }
}