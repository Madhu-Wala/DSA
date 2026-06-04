class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0;
        int start=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            //end char added
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            //shrink the window untill the duplicate is removed
            while(map.get(s.charAt(end))>1){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start))==0){
                    map.remove(s.charAt(start));
                }
                start++;
            }
            maxlen=Math.max(maxlen,end-start+1);
        }
        return maxlen;
    }
}
