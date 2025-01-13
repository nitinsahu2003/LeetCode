class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        boolean[] prev = new boolean[n+1];
        prev[0] = true;

        for(int j=1;j<=n;j++){
            if(p.charAt(j-1) == '*') prev[j] = prev[j-1];
        }

        for(int i=1;i<=m;i++){
            boolean[] curr = new boolean[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') curr[j] = prev[j-1];
                else if(p.charAt(j-1) == '*') curr[j] = curr[j-1] || prev[j];
            }
            prev = curr;
        }
        return prev[n];
    }
}