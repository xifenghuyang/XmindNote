package com.yq.leetcode.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc03501Test {

    @Test
    public void searchInsert() {
        int[] nums = {1,3,5,6};
        int target = 7;
        Lc03501 lc035 = new Lc03501();
        System.out.println(lc035.searchInsert(nums,target));
    }
}