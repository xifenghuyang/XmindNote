import java.util.List;

public class SwapTwoNode {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        ListNode tempNext = cur;
        boolean flag = true;
        while (cur != null && cur.next != null) {
            tempNext = cur.next;

            pre.next = tempNext;
            cur.next = tempNext.next;
            tempNext.next = cur;

            if (flag) {
                head = pre.next;
                flag = false;
            }
            pre = cur;
            cur = pre.next;
        }
        return head;
    }

    public static void main(String[] args){
        SwapTwoNode test = new SwapTwoNode();
        ListNode head = null;
        ListNode cur = null;
        for(int i=0; i<4; i++){
            ListNode temp = new ListNode(i+1);
            if(i==0){
                head= temp;
                cur = head;
            }
            cur.next = temp;
            cur = temp;
        }
        test.swapPairs(head);

    }


}
