package com.yq.leetcode;

import com.yq.leetcode.sort.Lc056;
import org.junit.Test;

public class Lc056Test {

    @Test
    public void merge() {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Lc056 lc056 = new Lc056();
        int[][] result = lc056.merge(intervals);

    }
}