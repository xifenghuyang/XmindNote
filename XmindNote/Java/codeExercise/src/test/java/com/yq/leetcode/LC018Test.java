package com.yq.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LC018Test {

    @Test
    public void fourSum() {
        LC018 lc018 = new LC018();
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {0,0,0,0};
        int target = 0;
        List<List<Integer>> result = lc018.fourSum(nums,target);
        result.stream().forEach(x->System.out.println(x));
    }
}