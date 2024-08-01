class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;

        HashSet<Integer> set =new HashSet<>();

        for(int i=0;i<n;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);

            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}