class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0){
            System.out.println("Cannot divide by zero");
        }
        if(dividend==0) return 0;
        if(dividend==divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // overflow ki condition
        int result=dividend/divisor;
        return result;
    }
}