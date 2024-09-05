class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m=rolls.length;
        int totalSum=(m+n)*mean;
        int currSum=0;
        for(int i=0;i<m;i++){
            currSum+=rolls[i];
        }
        int missingSum=totalSum-currSum;
        if(missingSum < n || missingSum > n*6) return new int[0];
        int[] result=new int[n];
        int quotient=missingSum/n;
        int remainder=missingSum%n;
        for(int i=0;i<n;i++){
            result[i]=quotient;
        }
        for(int i=0;i<remainder;i++){
            result[i]++;
        }
        return result;
    }
}