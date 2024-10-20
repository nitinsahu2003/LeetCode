class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int n=(n1+n2);  //complete length  
        int left=(n1+n2+1)/2;   //length of left half
        int low=0, high=n1;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1,l2,r1,r2;
            if(mid1>0) l1=nums1[mid1-1];
            else l1=Integer.MIN_VALUE;

            if(mid2>0) l2=nums2[mid2-1];
            else l2=Integer.MIN_VALUE;

            if(mid1<n1) r1=nums1[mid1];
            else r1=Integer.MAX_VALUE;

            if(mid2<n2) r2=nums2[mid2];
            else r2=Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                if(n%2==1) return Math.max(l1,l2);
                else return ((double)(Math.max(l1,l2)+Math.min(r1,r2)))/2.0;
            }else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}