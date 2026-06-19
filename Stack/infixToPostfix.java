package Preparation;
import java.util.HashMap;
import java.util.Scanner;

public class InfixToPostfix {
    static class StackCustom<T>{
        private T[] stack;
        private int top=-1;
        @SuppressWarnings("unchecked")
        public StackCustom(){
            this.stack=(T[]) new Object[100];
        }
        public boolean isEmpty(){
            return (top==-1);
        }
        public boolean isFull(){
            return (top==stack.length-1);
        }
        public void push(T val){
            if(isFull()){
                System.out.println("Stack overflow");
                return;
            }
            stack[++top]=val;
        }
        public T peek(){
            if(isEmpty()){
                System.out.println("Stack empty");
                return null;
            }
            return stack[top];
        }
        public T pop(){
            if(isEmpty()){
                System.out.println("Stack empty");
                return null;
            }
            T removed=stack[top];
            stack[top]=null;
            top--;
            return removed;
        }
    }
    public static void main(String[] args) {
        StackCustom<Character> st=new StackCustom<>();
        //infix to postfix
        Scanner sc=new Scanner(System.in);
        HashMap<Character,Integer> priority=new HashMap<>();
        priority.put('*', 2);
        priority.put('/',2);
        priority.put('+',1);
        priority.put('-',1);
        String infix =sc.nextLine();
        StringBuilder s=new StringBuilder();
        for(char ch:infix.toCharArray()){
            if(Character.isDigit(ch) || Character.isLetter(ch)){
                s.append(ch);
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(st.peek()!='('){
                    s.append(st.pop());
                }st.pop();
            }else{
                //operands
                if(st.isEmpty() || st.peek()=='('){
                    st.push(ch);
                }else {
                    while(priority.get(st.peek())>=priority.get(ch)){
                        s.append(st.pop());
                        if(st.isEmpty() || st.peek()=='('){
                            break;
                        }
                    }st.push(ch);
                }
            }
        }
        while(!st.isEmpty()){
            s.append(st.pop());
        }
        System.out.println("Postfix: "+s);
    }
}
