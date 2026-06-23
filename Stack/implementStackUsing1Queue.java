class MyStack {
    private ArrayDeque<Integer> q1;
    public MyStack() {
        q1=new ArrayDeque<>();
    }
    
    public void push(int x) {
       q1.push(x);
    }
    
    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.pop();
    }
    
    public int top() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
