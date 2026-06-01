class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
       int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int key:nums){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()>n/3){
                list.add(e.getKey());
            }
        }
        return list;
    }
}
