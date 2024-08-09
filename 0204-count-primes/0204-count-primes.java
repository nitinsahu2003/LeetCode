class Solution {
    public int countPrimes(int n) {

        if(n<=2){
            return 0;
        }
        int limit=(int)Math.sqrt(n);
        boolean[] isPrime =new boolean[n];
        for(int i=2;i<n;i++){
                isPrime[i]=true;
        }

        for(int i=2;i<=limit;i++){
            if(isPrime[i]){
            for(int j=i*i;j<n;j+=i){
                isPrime[j]=false;
            }
        }
    }
        int count=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
   
    }
}