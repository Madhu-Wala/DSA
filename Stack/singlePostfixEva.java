package Preparation;
import Preparation.InfixToPostfix.StackCustom;

import java.util.Scanner;
//note this code can handle only single digit postfix evaluation
public class PostfixEva {
    public static void main(String[] args) {
        StackCustom<Integer> st=new StackCustom<>();
        Scanner sc=new Scanner(System.in);
        String postfix=sc.nextLine();
        int ans=0;
        for(char ch:postfix.toCharArray()){
            if(Character.isDigit(ch)){
                st.push(Character.getNumericValue(ch));
            }else{
                //operand
                int val1=st.pop();
                int val2=st.pop();
                if(ch=='+'){
                    ans=val2+val1;
                }else if(ch=='-'){
                    ans=val2-val1;
                }else if(ch=='*'){
                    ans=val2*val1;
                }else if(ch=='/'){
                    ans=val2/val1;
                }
                st.push(ans);
            }
        }
        System.out.println(ans);
    }
}
