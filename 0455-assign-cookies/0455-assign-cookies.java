class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int left=0, right=0;
        while(left<s.length && right<g.length){
            if(g[right]<=s[left]) right++;
            left++;
        }
        return right;
    }
}