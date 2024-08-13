class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> intersectionSet=new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            if(set.contains(nums2[j])){
                intersectionSet.add(nums2[j]);
            }
        }
        int[] findIntersection=new int[intersectionSet.size()];
        int i=0;
        for(int num:intersectionSet){
            findIntersection[i++]=num;
        }
        return findIntersection;
    }
}