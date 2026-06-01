class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int j=0;j<nums.length;j++){
            if(freqMap.containsKey(nums[j])){
                int i=freqMap.get(nums[j]);
                if(Math.abs(i-j)<=k)return true;
            }
            freqMap.put(nums[j],j);
        }
        return false;
    }
}
