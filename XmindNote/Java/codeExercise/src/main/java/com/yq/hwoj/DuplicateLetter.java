package com.yq.hwoj;

import java.util.*;

/**
 * @author admin
 */
public class DuplicateLetter {

    /**
     * 栈：
     * 1.当前元素=栈顶元素，continue
     * 2.当前元素>栈顶元素，入栈
     * 3.当前元素<栈顶元素，且之后没有栈顶元素，入栈
     * 4.当前元素<栈顶元素，且之后有栈顶元素，出栈
     * @param s
     * @return
     */

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(stack.contains(c)) continue;
           while (!stack.empty() && c<stack.peek() && s.indexOf(stack.peek(),i) != -1){
               stack.pop();
           }
           stack.push(c);
        }
        // 倒出结果
        char[] result= new char[stack.size()];
        for(int i=0; i<stack.size(); i++){
            result[i] = stack.get(i);
        }
        return new String(result);
    }

}
