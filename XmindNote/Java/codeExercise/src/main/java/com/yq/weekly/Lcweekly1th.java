package com.yq.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author admin
 * 排序计数--easy
 */
public class Lcweekly1th {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        for (int i = 0; i < numsCopy.length; i++) {
            if (!map.containsKey(numsCopy[i])) {
                map.put(numsCopy[i], i);
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}
