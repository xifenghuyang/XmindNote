package com.yq.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LC040Test {

    @Test
    public void combinationSum() {
        LC040 lc040 = new LC040();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = lc040.combinationSum(candidates,target);
        result.stream().forEach(x->System.out.print(x.toString()));
    }
}