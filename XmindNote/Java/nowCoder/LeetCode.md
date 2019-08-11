# 1.数组

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(numMap.containsKey(target-nums[i])){
                return new int[] {numMap.get(target-nums[i]),i};
            }else{
                numMap.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException();
    }
}
```

1. 不合法的结果应该 **throw new IllegalArgumentException();**
2. 直接初始化并创建数组 new int[] {numMap.get(target-nums[i]),i};
3. HashMap不支持基本类型。

时间复杂度，O(n^2)用时78ms，O(n)用时7ms。

# 2. 链表

#### [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
           ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur=nextTemp;
        }
        return pre;
    }

}
```



1. 编程的一个原则：不改变输入参数。重新定义并接收。
2. 指针一个原则：前脚、当前、后脚。三步走。
3. pre从空开始，避免一些多余的判断

#### [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        ListNode tempNext = cur;
        boolean flag = true;
        while(cur!=null && cur.next!=null){
            tempNext = cur.next;
            
            pre.next = tempNext;
            cur.next = tempNext.next;
            tempNext.next = cur;
            
            if(flag){
                head = pre.next;
                flag = false;
            }
            pre = cur;
            cur = pre.next;
        }
        return head;
        
    }
}
```



1. 在用pre的时候，使用空节点技巧，将链表串起来。
2. 把最外层的while写成if了。
3. 依然是pre、cur、next三步走策略。

