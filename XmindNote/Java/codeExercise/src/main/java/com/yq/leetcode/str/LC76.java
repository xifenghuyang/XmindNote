package com.yq.leetcode.str;

import java.util.HashMap;

/**
 * @author admin
 * 双指针特点：满足条件连续子串
 */
public class LC76 {

    /**
     * 建立目标字符的map表
     * 记录当前map中的最小值和最大值
     * 迭代更新abs距离
     * <p>
     * 目标字符串可能存在重复字符
     * 因此用滑动窗口法，右移可行解，左移最小解
     */
    public String minWindow(String s, String t) {
        // 定义目标map, 当前map
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        // 遍历s
        int left = 0;
        int right = 0;
        int valid = 0; // 用来记录窗口中满足条件的元素个数，很巧妙
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < s.length()) {
            char temp = s.charAt(right);
            right++;
            // 更新窗口值, 右移找到可行解
            if (target.containsKey(temp)) {
                window.put(temp, window.getOrDefault(temp, 0) + 1);
                if (window.get(temp).equals(target.get(temp))) {
                    valid++;
                }
            }
            // 左移找到最小解
            while (valid == target.size()) {
                // 更新当前解
                if( minLen > (right - left) ){
                    minLen = right - left;
                    start = left;
                }
                // 要移除的字符
                char leftChar = s.charAt(left);
                left++;
                if(target.containsKey(leftChar)){
                    if(window.get(leftChar).equals(target.get(leftChar))){
                        valid--;
                    }
                    window.put(leftChar,window.get(leftChar)-1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(start,start+minLen);
    }
//    public String minWindow(String s, String t) {
//        if(t.length()>s.length()) return "";
//        <Character, Integer> tMap = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            tMap.put(t.charAt(i), Integer.MIN_VALUE);
//        }
//        // 遍历str
//        int resultBegin = -1;
//        int resultEnd = -1;
//        int resultLen = Integer.MAX_VALUE;
//        int curMin = Integer.MAX_VALUE;
//        int curMax = Integer.MIN_VALUE;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (!tMap.containsKey(ch)) {
//                continue;
//            }
//            // tMap中存在才需要计算
//            tMap.put(ch, i);
//            List<Integer> ttt = tMap.values().stream().sorted().collect(Collectors.toList());
//            curMin = ttt.get(0);
//            curMax = ttt.get(ttt.size()-1);
//            // 目标不全
//            if (tMap.containsValue(Integer.MIN_VALUE)) {
//                continue;
//            }
//            // 计算更新
//            int curLen = curMax - curMin;
//            if(resultLen > curLen){
//                resultLen =  curLen;
//                resultBegin = curMin;
//                resultEnd = curMax;
//            }
//        }
//
//        if(tMap.containsValue(Integer.MIN_VALUE)){
//            return "";
//        }else {
//            return s.substring(resultBegin,resultEnd+1);
//        }
//    }

    public static void main(String[] args) {
        LC76 lc76 = new LC76();
//        String inputS = "ADOBECODEBANC", T = "ABC";
        String inputS = "aa", T = "aa";
        String sss = lc76.minWindow(inputS, T);
        System.out.printf(sss);
    }

}
