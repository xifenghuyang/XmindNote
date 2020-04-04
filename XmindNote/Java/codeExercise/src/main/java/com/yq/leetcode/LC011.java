package com.yq.leetcode;

/**
 * 盛水容器
 */

public class LC011 {

    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int result = 0;
        while (i<j){
            int temp = Math.min(height[i],height[j])*(j-i);
            result = temp>result?temp:result;
            if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return result;
    }
}
