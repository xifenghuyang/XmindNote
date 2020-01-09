package LeetCode.LC703;//Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
// Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream. 
//
// Example: 
//
// 
//int k = 3;
//int[] arr = [4,5,8,2];
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4
//kthLargest.add(5);   // returns 5
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8
// 
//
// Note: 
//You may assume that nums' length ≥ k-1 and k ≥ 1. 
// Related Topics Heap


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {

    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        q = new PriorityQueue<>(k);
        for(int i=0; i<nums.length; i++){
           add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(q.size()<k){
            q.offer(val);
        }else {
            if(q.peek()<val){
                q.poll();
                q.offer(val);
            }
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
