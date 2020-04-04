package com.yq.leetcode;

public class LC027 {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if(nums[i]!=val){
                i++;
                continue;
            }
            if(nums[j] == val){
                j--;
                continue;
            }
            nums[i]=nums[j];
            i++;j--;

        }
        return j+1;
    }

}
