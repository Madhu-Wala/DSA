//Monotonic Stack Approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] a=new int[temperatures.length];
        // Stack<Integer> st=new Stack<>();
        //since above commented legeacy class is synchronized, it had slower runtime. switching to ArrayDeque caused it improve from 90ms to 28ms.
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<temperatures.length;i++){
            if(st.isEmpty()){
                st.push(i);
                continue;
            }
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                a[st.peek()]=i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        //mark remaining ones as 0 
        //commenting this caused my runtime to jump from 28ms to 26ms
        // while(!st.isEmpty()){
        //     a[st.peek()]=0;
        //     st.pop();
        // }
        return a;
    }
}
