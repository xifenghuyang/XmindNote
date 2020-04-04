package com.yq.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC027Test {

    @Test
    public void removeElement() {
        LC027 lc027 = new LC027();
//        int[] nums = {3,2,2,3};
//        int val = 2;
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int result = lc027.removeElement(nums,val);
        System.out.println(result);
    }
}