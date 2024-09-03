class Solution {
    public int getLucky(String s, int k) {
        StringBuilder number=new StringBuilder();
        for(char c:s.toCharArray()){
            int idx=c-'a'+1;
            number.append(idx);
        }
        int sum=0;
        String numString=number.toString();
        for(char c:numString.toCharArray()){
            sum+=c-'0';
        }
        while(--k>0){
            int tempSum=0;
            while(sum>0){
                tempSum+=sum%10;
                sum/=10;
            }
            sum=tempSum;
        }
        return sum;
    }
}