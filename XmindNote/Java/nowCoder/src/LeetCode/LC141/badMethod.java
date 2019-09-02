package LeetCode.LC141;

/**
 * 意外1：未考虑边界条件——head为空
 */

public class badMethod {
    public boolean hasCycle(ListNode head) {
        // 方法一：遍历节点，设置超时。
        if(head==null) return false;
        ListNode point = head;
        long timeStart = System.currentTimeMillis();
        long timeEnd = System.currentTimeMillis();
        while(point.next!=null && timeEnd-timeStart < 10){
            point = point.next;
            timeEnd = System.currentTimeMillis();
        }
        if(timeEnd-timeStart >= 10){
            return true;
        }
        return false;
    }
}


