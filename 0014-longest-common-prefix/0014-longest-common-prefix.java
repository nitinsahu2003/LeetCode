class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb= new StringBuilder();

        Arrays.sort(strs);

        // char[] first=strs[0].toCharArray();
        // char[] last=strs[strs.length-1].toCharArray();

        String str1=strs[0];
        String str2=strs[strs.length-1];
        int i=0;

        while(i<str1.length()){
            if(str1.charAt(i)==str2.charAt(i)){
                i++;
            }else{
                break;
            }
        }
        return i==0?"":str1.substring(0,i);
    }
}