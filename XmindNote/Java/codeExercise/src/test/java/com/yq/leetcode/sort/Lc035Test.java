package com.yq.leetcode.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc035Test {

    @Test
    public void searchInsert() {

        int[] nums = {1,3,5,6};
        int target = 0;
        Lc035 lc035 = new Lc035();
        System.out.println(lc035.searchInsert(nums,target));

    }
}