class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> compMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment=target-nums[i];
            if(compMap.containsKey(compliment)){
                return new int[] {compMap.get(compliment),i};
            }
            compMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
