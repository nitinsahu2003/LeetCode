class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] curr = new int[2];
        int[] ahead = new int[2];
        ahead[0] = curr[0] = 0;
        int profit = 0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy == 0){
                    profit = Math.max(0 + ahead[0],
                    -prices[ind] + ahead[1]);
                }
                if(buy == 1){
                    profit = Math.max(0 +ahead[1],
                    prices[ind] - fee + ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr.clone();
        }
        return curr[0];
    }
}