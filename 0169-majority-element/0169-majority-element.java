class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxFrequency=0;
        int maxFrequencyElement=-1;
        for(int key:map.keySet()){
            int frequency=map.get(key);
            if(frequency>maxFrequency){
                maxFrequency=frequency;
                maxFrequencyElement=key;
            }
        }
        return maxFrequencyElement;
    }
}