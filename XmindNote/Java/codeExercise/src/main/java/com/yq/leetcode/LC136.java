package com.yq.leetcode;

import java.util.Arrays;

public class LC136 {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = nums[nums.length-1];
        for(int i=0; i<nums.length/2;i++){
            if(nums[2*i] != nums[2*i+1]){
                result = nums[2*i];
                break;
            }
        }
        return result;
    }
}
