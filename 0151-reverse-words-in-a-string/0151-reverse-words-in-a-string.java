class Solution {
    public String reverseWords(String s) {
        int low=0, high=s.length()-1;
        while(low<=high && s.charAt(low) ==' ') low++;
        while(high>=low && s.charAt(high) ==' ') high--;
        StringBuilder temp=new StringBuilder();
        List<String> ans=new ArrayList<>();
        while(low<=high){
            char ch=s.charAt(low);
            if(ch != ' ') temp.append(ch);
            else if(temp.length()>0){
                ans.add(temp.toString());
                temp.setLength(0);
            }
            low++;
        }
        if(temp.length()>0){
            ans.add(temp.toString());
        }
        Collections.reverse(ans);
        return String.join(" ",ans);
    }
}