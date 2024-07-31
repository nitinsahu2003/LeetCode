class Solution {
    public int fib(int n) {
        int sum=0;
        int a=0;
        int b=1;
        for(int i=0;i<n;i++){
            sum=a+b;
            b=a;
            a=sum;
        }
        return sum;
    }
}