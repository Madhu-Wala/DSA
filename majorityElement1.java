class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int key:nums){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()>n/2){
                return e.getKey();
            }
        }
        return -1;
    }
}
