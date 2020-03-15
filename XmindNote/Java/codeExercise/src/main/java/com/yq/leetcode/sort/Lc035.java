package com.yq.leetcode.sort;

public class Lc035 {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (target < nums[start]) {
            return start;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        return binarySearch(nums, target, start, end);

    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[mid] < target && nums[mid + 1] > target) {
            return mid + 1;
        }
        if (nums[mid] < target) {
            start = mid + 1;
            return binarySearch(nums, target, start, end);
        } else if (nums[mid] > target) {
            end = mid;
            return binarySearch(nums, target, start, end);
        } else {
            return mid;
        }
    }

}
