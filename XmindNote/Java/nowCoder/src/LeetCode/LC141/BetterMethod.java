package LeetCode.LC141;

/**
 * 问题：
 * 1. 在LeetCode环境下容易写错字母
 * 2. 将第2个if判断误写在外面了
 * 分析：
 * 1. 时间复杂度 O(n)，空间复杂度O(1)
 */

public class BetterMethod {
//    // 方法三：龟兔赛跑双指针
//    public boolean hasCycle(ListNode head) {
//        ListNode quickPoint = head;
//        ListNode slowPoint = head;
//        while(slowPoint!=null && slowPoint.next!=null){
//            slowPoint = slowPoint.next;
//            if(quickPoint!=null && quickPoint.next!=null && quickPoint.next.next!=null){
//                quickPoint = quickPoint.next.next;
//                if(quickPoint!=null && slowPoint!=null && quickPoint==slowPoint)return true;
//            }
//        }
//        return false;
//
//    }

    // 标准答案
    public boolean hasCycle(ListNode head) {
        // 不足2步，边界判定
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast) {
            // 判断fast到头
            if(fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
