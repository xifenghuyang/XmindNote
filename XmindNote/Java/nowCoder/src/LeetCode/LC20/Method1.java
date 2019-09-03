package LeetCode.LC20;

import java.util.Stack;

/**
 * 问题:
 *  1. char的比较用单引号。双引号表示字符串
 *  2. 栈pop的操作要考虑pop出空的情况。
 *  3. 输入为空的时候要求返回为true。
 */


public class Method1 {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character tempStr = s.charAt(i);
            if(tempStr =='(' || tempStr == '{' || tempStr == '['){
                myStack.push(tempStr);
            }else {
                if(myStack.size()==0){
                    return false;
                }
                if(tempStr == ')' && !myStack.pop().equals('(')){
                    return false;
                }else if(tempStr.equals(']') && !myStack.pop().equals('[')) {
                    return false;
                }else if(tempStr.equals('}') && !myStack.pop().equals('{')){
                    return false;
                }
            }
        }
        if(myStack.size()==0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        Method1 one = new Method1();
        boolean result = one.isValid("");
        System.out.println(result);
    }
}
