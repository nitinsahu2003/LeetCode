class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int k = helper(word1, word2);
        return (m-k)+(n-k);
    }
    public int helper(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];

        for(int ind1=1;ind1<=m;ind1++){
            for(int ind2=1;ind2<=n;ind2++){
                if(word1.charAt(ind1-1) == word2.charAt(ind2-1)) curr[ind2] = 1 + prev[ind2-1];
                else curr[ind2] = Math.max(curr[ind2-1], prev[ind2]);
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}