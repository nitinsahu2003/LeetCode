class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int count = 10, uniqueDigits = 9, availableDigits = 9;

        for(int i = 2; i <= n && availableDigits > 0 ; i++){
            uniqueDigits *= availableDigits;
            count += uniqueDigits;
            availableDigits--;
        }
        return count;        
    }
}