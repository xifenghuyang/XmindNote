package com.yq.leetcode.dp;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @author admin
 */
public class LC152 {

    public int maxProduct(int[] nums) {
        // 根据无后性，判定使用动态规划
        // 特殊点在于，数组中存在负值，会导致相乘后，最小变最大，最大变最小，
        // so we need record curMax, curMin
        int max = Integer.MIN_VALUE;
        int curMax = 1;
        int curMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(curMax * num, num);
            curMin = Math.min(curMin * num, num);
            max = Math.max(curMax, max);
        }
        return max;
    }

}
