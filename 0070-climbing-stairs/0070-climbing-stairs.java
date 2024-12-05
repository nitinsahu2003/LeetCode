class Solution {
    public int climbStairs(int n) {
       int prev1=1, prev2=1;
       for(int i=2;i<=n;i++){
        int curr=prev1+prev2;
        prev2=prev1; // storing prev2 in prev 1
        prev1=curr; //storing prev1 in curr
       }
       return prev1;
    }
}