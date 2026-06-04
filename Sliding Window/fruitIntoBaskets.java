class Solution {
    public int totalFruit(int[] fruits) {
        int start=0,end=0,maxlen=0,currlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(end<fruits.length){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            if(map.size()>2){
                map.put(fruits[start],map.get(fruits[start])-1);
                if(map.get(fruits[start])==0){
                    map.remove(fruits[start]);
                }
                start++;
            }
            currlen=end-start+1;
            maxlen=Math.max(currlen,maxlen);
            end++;
        }
        return maxlen;
    }
}
