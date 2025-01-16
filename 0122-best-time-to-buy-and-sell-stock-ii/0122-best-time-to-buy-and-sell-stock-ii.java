class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];

        ahead[0] = curr[0] = 0;
        int profit = 0;

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy == 0) profit = Math.max(ahead[0], -prices[ind] + ahead[1]);
                if(buy == 1) profit = Math.max(ahead[1], prices[ind] + ahead[0]);
                curr[buy] = profit;
            }
            System.arraycopy(curr, 0, ahead, 0, 2);
        }
        return curr[0];
    }
}