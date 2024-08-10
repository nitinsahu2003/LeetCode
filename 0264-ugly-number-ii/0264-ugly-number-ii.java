class Solution {
    public int nthUglyNumber(int n) {
        int[] arr=new int[n];
        arr[0]=1;
        int p2=0,p3=0,p5=0;

        for(int i=1;i<n;++i){
            int next2=arr[p2]*2;
            int next3=arr[p3]*3;
            int next5=arr[p5]*5;

            arr[i]=Math.min(next2,Math.min(next3,next5));

            if(arr[i]==next2){
                ++p2;
            }
            if(arr[i]==next3){
                ++p3;
            }
            if(arr[i]==next5){
                ++p5;
            }
        }
        return arr[n-1];
    }
}