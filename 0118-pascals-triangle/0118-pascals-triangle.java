class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            List<Integer> list=new ArrayList<>();
            for(int col=1;col<=row;col++){
                list.add((int)nCr(row-1,col-1));
            }
            ans.add(list);
        }
        return ans;
    }
    public long nCr(int numRows, int r){
        long result=1;
        for(int i=0;i<r;i++){
            result=result*(numRows-i);
            result=result/(i+1);
        }
        return result;
    }
}