class Solution {
    public int mySqrt(int x) {
        
        if(x<2){
            return x;
        }
        long guess=x;
        while(guess*guess>x){
            guess=(guess+x/guess)/2;

        }
        return (int) guess;
    }   
}