package com.yq.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LC1365Test {

    @Test
    public void smallerNumbersThanCurrent() {

        LC1365 lc1365 = new LC1365();
        int[] nums = {8,1,2,2,3};
        int[] result = lc1365.smallerNumbersThanCurrent(nums);
        Arrays.asList(result).stream().forEach(x->System.out.println(x));
    }
}