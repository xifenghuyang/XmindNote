package com.yq.leetcode.str;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author admin
 */
public class LC394 {
    public String decodeString(String s) {
        // 存储数字
        Stack<Integer> numStack = new Stack<>();
        // 存储字符
        Stack<String> strStack = new Stack<>();
        // 存储子串
        StringBuilder sb = new StringBuilder();
        // 遍历
        int len = s.length();
        for (int i = 0; i < len ; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = ch - '0';
                while (i+1 < len && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                // 放入数字栈
                numStack.push(num);
            }else if(ch == '['){
                // 遇到左括号，把积攒的sb子串放入字符串栈，重新开始
                strStack.push(sb.toString());
                // 清理sb容器
                sb = new StringBuilder();
            }else if(ch == ']'){
                // 遇到右括号，原来的
                StringBuilder temp = new StringBuilder(strStack.pop());
                //重复的
                int repeats = numStack.pop();
                while (repeats != 0){
                    temp.append(sb);
                    repeats--;
                }
                sb = temp;
            }else {
                // 正常情况加入sb
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        LC394 lc394 = new LC394();
//        lc394.decodeString("3[a]2[bc]");
//        lc394.decodeString("3[a2[c]]");
       String result = lc394.decodeString( "2[abc]3[cd]ef");
        System.out.println(result);
    }

}
