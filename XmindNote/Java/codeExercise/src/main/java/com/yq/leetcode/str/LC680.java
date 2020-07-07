package com.yq.leetcode.str;

import javafx.util.Pair;

import javax.net.ssl.SSLServerSocket;
import javax.sound.midi.Soundbank;
import javax.xml.stream.events.StartDocument;

/**
 * @author admin
 */
public class LC680 {

    public boolean validPalindrome(String s) {
        // 边界，输入判断
        if(s == null){
            return false;
        }
        if(s.length() < 3){
            return true;
        }
        boolean canDel = true;
        int start = 0;
        int end = s.length()-1;
        return reverse(s,start,end,canDel);
    }

    public boolean reverse(String s, int start, int end,boolean canDel){
        if(start >= end){
            return true;
        }
        if(s.charAt(start) != s.charAt(end) && canDel){
            return reverse(s,start+1,end,false)
                    || reverse(s,start,end-1, false);
        }else if(s.charAt(start) != s.charAt(end) && !canDel){
            return false;
        }else {
            return reverse(s,start+1,end-1,canDel);
        }
    }

    public static void main(String[] args){
        LC680 lc680 = new LC680();
        String input = "ebcbb ececabbacec bbcbe";
        System.out.println(lc680.validPalindrome(input));
    }

}
