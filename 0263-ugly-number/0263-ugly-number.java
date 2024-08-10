class Solution {
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        int[] primes={2,3,5};

        for(int prime:primes){
            while(n % prime==0){
                n /= prime;
            }
        }
        return n==1;
    }
}