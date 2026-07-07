class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad=new LinkedList<>();
        Queue<Integer> dire=new LinkedList<>();
        int n=senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R'){
                rad.offer(i);
            }else{
                dire.offer(i);
            }
        }
        while(!rad.isEmpty() && !dire.isEmpty()){
            int r=rad.peek();
            int d=dire.peek();
            rad.poll();
            dire.poll();
            if(r<d)?
                rad.offer(r+n);
            }else{
                dire.offer(d+n);
            }
        }
        if(rad.isEmpty()){
            return "Dire";
        }
        return "Radiant";
    }
}
