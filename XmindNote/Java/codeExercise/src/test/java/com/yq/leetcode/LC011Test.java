package com.yq.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC011Test {

    @Test
    public void maxArea() {
        LC011 lc011 = new LC011();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = lc011.maxArea(height);
        System.out.println(result);
    }
}