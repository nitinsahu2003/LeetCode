class Solution {
    public String reverseVowels(String s) {
        char[] charArray=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        String vowels="aeiouAEIOU";

        while(left<right){

            while(left<right && vowels.indexOf(charArray[left])==-1){
                left++;
            }

            while(left<right && vowels.indexOf(charArray[right])==-1){
                right--;
            }
                char temp=charArray[left];
                charArray[left]=charArray[right];
                charArray[right]=temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}