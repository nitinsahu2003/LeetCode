class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>(); // creating new arrayList
        long result=1;
        for(int i=0;i<=rowIndex;i++){
            ans.add((int)(result));
            result=result*(rowIndex-i);     // formula for combination
            result=result/(i+1);
        }
        return ans;             //returning answer
    }   
}