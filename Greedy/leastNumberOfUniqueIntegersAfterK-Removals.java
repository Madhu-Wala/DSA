class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num: arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> frequencies=new ArrayList<>(map.values());
        Collections.sort(frequencies);
        int unique=frequencies.size();
        for(int freq:frequencies){
            if(k>=freq){
                k-=freq;
                unique--;
            }
            else{
                break;
            }
        }
        return unique;
    }
}
