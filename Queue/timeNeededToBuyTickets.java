class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        int t=0;
        for(int i=0;i<tickets.length;i++){
            q.offer(i);
        }
        while(tickets[k]!=0){
            count++;
            tickets[q.peek()]--;
            t=q.poll();
            if(tickets[t]!=0){
                q.offer(t);
            }
        }
        return count;
    }
}
