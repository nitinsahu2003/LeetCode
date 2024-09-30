class Solution {
    public int reverse(int x) {
        int num=Math.abs(x); // kisi bhi number ki absolute value nikalne ke liye 
        int rev=0;
        while(num!=0){
            int ld=num%10; // remainder or last digit nikalne ke liye 

            if(rev>(Integer.MAX_VALUE-ld)/10) return 0;  // overflow ki condition check krne ke liye
            rev=(rev*10)+ld; 
            num=num/10;
        }
        if(x<0) return -rev; //agar koi number negative h to usko sign ke according hi return krenge
        else return rev;
    }
}