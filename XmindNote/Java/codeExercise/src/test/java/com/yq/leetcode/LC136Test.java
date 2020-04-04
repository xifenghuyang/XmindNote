package com.yq.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC136Test {

    @Test
    public void singleNumber() {
        LC136 lc136 = new LC136();
//        int[] nums = {4,1,2,1,2};
//        int[] nums = {4};
        int[] nums = {1,3,1,-1,3};
        int result = lc136.singleNumber(nums);
        System.out.println(result);

    }
}