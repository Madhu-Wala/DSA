class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        int count0=0,count1=0;
        for(int i=0;i<students.length;i++){
            if(students[i]==1){
                count1++;
            }else{
                count0++;
            }
           q.offer(i);
        }
        int j=0;
        while(j<sandwiches.length){
            if(students[q.peek()]==sandwiches[j]){
                int t=q.poll();
                j++;
                if(students[t]==1){
                    count1--;
                }else{
                    count0--;
                }
            }else{
                q.offer(q.poll());
                if(sandwiches[j]==1 && count1==0){
                    break;
                }
                if(sandwiches[j]==0 && count0==0){
                    break;
                }
            }
        }
        return q.size();
    }
}
