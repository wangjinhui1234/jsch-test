package kaer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stackTest {
    public static void main(String[] args) {
       String str =  "(]";
        char c = str.charAt(1);
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

       StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        boolean bea =  isValid(str);
        System.out.println(bea
        );
    }
    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack();

        int m =0;
        if( ((m % 2) == 0)){
            for ( int i = 0 ; i < m ;i++){
                if(s.charAt(i) == '('){
                    charStack.push(')');
                }else if(s.charAt(i) == '{'){
                    charStack.push('}');
                }else if(s.charAt(i) == '['){
                    charStack.push(']');
                }else if(charStack.isEmpty() ||  charStack.peek() != s.charAt(i)){
                    return false;
                }else{
                    charStack.pop();
                }
            }
        }else {
            return  false;
        }
        return  charStack.isEmpty() ;
    }
}
