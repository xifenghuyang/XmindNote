package com.yq.leetcode;

import java.util.*;

/**
 * 双指针法
 * 两定两动法
 */

public class LC018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (nums.length < 4) return pathList;
        Arrays.sort(nums);
        int a, b, c, d;
        for (a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;  // 去重，保证nums[a]发生变化
            for (b = a + 1; b < nums.length - 2; b++) {
                if (b>a+1 && nums[b] == nums[b - 1]) continue;  // 去重，保证nums[b]发生变化
                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                        List<Integer> path = new ArrayList<>();
                        path.add(nums[a]);
                        path.add(nums[b]);
                        path.add(nums[c]);
                        path.add(nums[d]);
                        pathList.add(path);
                        while (c<d && nums[c+1] == nums[c]) {
                            c++;
                        }
                        while (c<d && nums[d-1] == nums[d]) {
                            d--;
                        }
                        c++;
                        d--;
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }
        return pathList;
    }

}
