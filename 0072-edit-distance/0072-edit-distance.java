class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int i=0;i<=n;i++){
            prev[i] = i;
        }
        for(int ind1=1;ind1<=m;ind1++){
            curr[0] = ind1;
            for(int ind2=1;ind2<=n;ind2++){
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)){
                    curr[ind2] = prev[ind2 - 1];
                }else{
                    curr[ind2] = 1 + Math.min(prev[ind2 - 1],
                    Math.min(prev[ind2], curr[ind2 - 1]));
                }
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}