package com.yq.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author admin
 */
public class LC84 {

    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peekFirst()]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if(stack.isEmpty()){
                    // 此时 height为最小值，乘以最大宽度
                    area = heights[top] * i;
                }else {
                    area = heights[top] * (i-stack.peekFirst() -1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()){
            int top = stack.pollFirst();
            if(stack.isEmpty()){
                area = heights[top] * i;
            }else {
                area = heights[top] * (i-stack.peekFirst() -1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
