package leetcode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class P_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode before = newHead;
        ListNode after = newHead;

        int i = 0;
        while(i <= n && before.next != null) {
            before = before.next;
            i++;
        }

        while(before.next != null) {
            after = after.next;
            before = before.next;
        }

        if(after.next != null) {
            if(after.next.next != null) {
                after.next = after.next.next;
            } else {
                after.next = null;
            }
        }

        return newHead.next;
    }


}
