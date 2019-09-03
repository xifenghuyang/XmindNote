package LeetCode.LC141;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题：
 * 1. Set消耗内存
 * 2. 第一把提交又忽略了边界条件。
 * 分析:
 * 1. 时间复杂度：O(n),含有n个元素的链表，每个元素最多访问1次，
 *  添加一个节点到哈希表中花费O(1)时间。
 * 2. 空间复杂度：O(n),取决于添加到哈希表中的元素数目，最多添加n个元素。
 */

public class GoodMethod {
    // 方法二：Set集合判重法
//    public boolean hasCycle(ListNode head) {
//        Set linkSet = new HashSet();
//        ListNode point = head;
//        if (point == null) return false;
//        while (point != null && !linkSet.contains(point)) {
//            linkSet.add(point);
//            point = point.next;
//            if (point == null) return false;
//        }
//        return true;
//    }

    // 标准答案
    public boolean hasCycle(ListNode head) {
        // 方法二：Set集合判重法
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}


