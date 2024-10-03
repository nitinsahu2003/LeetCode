class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(Integer num:nums){
            if(!(set.add(num))) return num;
        }
        return -1;
    }
}