package com.yq.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<numsCopy.length; i++){
            if(!map.containsKey(numsCopy[i])){
                map.put(numsCopy[i],i);
            }
        }
        for(int i=0;i<nums.length; i++){
            numsCopy[i] = map.get(nums[i]);
        }
        return numsCopy;
    }

}
