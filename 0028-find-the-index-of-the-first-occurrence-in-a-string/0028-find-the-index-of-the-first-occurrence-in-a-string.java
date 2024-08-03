class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length();
        
        for(int i=0;i<m;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(compare(haystack,needle,i)==true){
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean compare(String haystack, String needle, int idx){
        int m=haystack.length();
        int n=needle.length();

        for(int i=0;i<n;i++){
            if(idx>=m){
                return false;
            }
            if(haystack.charAt(idx++)!=needle.charAt(i)){
                return false;
            }
        }
        return true;
    }
}