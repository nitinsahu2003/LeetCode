class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combo=new ArrayList<>();
        generate(combo,"",0,0,n);
        return combo;
    }
    public void generate(List<String> combo, String curr, int open, int close,int max){
        if(curr.length()==max*2){
            combo.add(curr);
            return;
        } 
        if(open<max) generate(combo,curr+"(",open+1,close,max);
        if(close<open) generate(combo,curr+")",open,close+1,max);
    }
}