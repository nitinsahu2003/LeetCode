class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currNum=num;
                int currStreak=1;
                while(set.contains(currNum+1)){
                    currNum++;
                    currStreak++;
                }
                longest=Math.max(longest,currStreak);
            }
        }
        return longest;
    }
}