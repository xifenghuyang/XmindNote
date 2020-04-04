package com.yq.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LC046Test {

    @Test
    public void permute() {
        LC046 lc046 = new LC046();
        int[] nums = {1,2,3};
        List<List<Integer>> result = lc046.permute(nums);
        result.stream().forEach(x->System.out.println(x));
    }
}