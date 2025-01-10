class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i] = 0;
        }
        for(int ind1=1;ind1<=m;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
            }
        }
        int len = dp[m][n];
        int i = m, j = n;
        int index = len-1;
        String ans = "";
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans += s1.charAt(i-1);
                index--;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                ans += s1.charAt(i-1);
                i--;
            }else{
                ans += s2.charAt(j-1);
                j--;
            }
        }
        while(i>0){
            ans += s1.charAt(i-1);
            i--;
        }
        while(j>0){
            ans += s2.charAt(j-1);
            j--;
        }
        String ans2 = new StringBuilder(ans).reverse().toString();
        return ans2;
    }
}