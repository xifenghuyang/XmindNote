package com.yq.leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LC039Test {

    @Test
    public void combinationSum() {
        LC039 lc039 = new LC039();
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = lc039.combinationSum(candidates,target);

        result.stream().forEach(x->System.out.print(x.toString()));

    }
}