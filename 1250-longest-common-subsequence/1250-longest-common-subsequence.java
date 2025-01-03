class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(); 
        int n = s2.length(); 

        int[] prev = new int[n + 1]; 
        int[] curr = new int[n + 1];

        for (int i1 = 1; i1 <= m; i1++) {
            for (int i2 = 1; i2 <= n; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) curr[i2] = 1 + prev[i2 - 1];    
                else curr[i2] = Math.max(prev[i2], curr[i2 - 1]);
            }
            prev = curr.clone();
        }
        return prev[n]; 
    }
}
