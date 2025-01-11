class Solution {
    public int numDistinct(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] prev = new int[n+1];
        prev[0] = 1;

        for(int i=1;i<=m;i++){
            for(int j=n;j>=1;j--){
                if(s1.charAt(i-1) == s2.charAt(j-1)) prev[j] += prev[j-1];
            }
        }
        return prev[n];
    }
}