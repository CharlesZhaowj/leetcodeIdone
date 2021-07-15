package testpack;

/**
 * 链表的结构
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(){
    }
    public ListNode(int val){
        this.val = val;
    }
}

public class ListNodeTest {
    /**
     * 产生链表
     * @return 链表
     */
    public static ListNode createLinkedList(){
        ListNode l1 = new ListNode(0);
        ListNode cur = l1;
        for(int i = 1; i <=5; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return l1;
    }

    /**
     * 打印链表
     * @param node
     */
    public static void printLinkedList(ListNode node){
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 反转链表
     * @param node
     * @return
     */
    public static ListNode reverseList(ListNode node) {
        ListNode newHead = new ListNode(0);
        while(node != null) {
            ListNode temp = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = temp;
        }
        return newHead.next;
    }

    /**
     * 反转一部分的链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = null;

        for(int i = 0; i < m-1; i++) {
            p2 = p1;
            p1 = p1.next;
        }

        ListNode pEnd = p1;
        ListNode pPre = p1;

        p1 = p1.next;
        for(int i = m+1; i <= n; i++) {
            ListNode temp = p1.next;
            p1.next = pPre;
            pPre = p1;
            p1 = temp;
        }

        pEnd.next = p1;
        if(p2 != null) {
            p2.next = pPre;
        } else {
            head = pPre;
        }
        return head;
    }

    /**
     * 归并两个排序链表
     * @param l1
     * @param l2
     * @return
     */
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null)
//            return l2;
//        if(l2 == null)
//            return l1;
//        if(l1.val <= l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }

    /**
     * 删除链表中的重复元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                ListNode temp = head.next;
                while(temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                if(temp.next == null){
                    head.next = null;
                } else {
                    head.next = temp.next;
                }
            }
            head = head.next;
        }
        return p;
    }

    /**
     * 判断链表是否回文
     * @param head
     * @return
     */
//    public boolean isPalindrome(testpack.ListNode head) {
//        if(head == null || head.next == null) {
//            return true;
//        }
//        testpack.ListNode pFast = head;
//        testpack.ListNode pSlow = head;
//        while(pFast != null && pFast.next != null) {
//            pFast = pFast.next.next;
//            pSlow = pSlow.next;
//        }
//        // 根据快指针是否为空判断奇偶
//        if(pFast == null) {
//
//        }
//    }

    public static void main(String[] args) {
        ListNode l1 = createLinkedList();
        printLinkedList(l1);
        ListNode l2 = reverseList(l1);
        printLinkedList(l2);
        ListNode l3 = reverseBetween(l2, 2, 4);
        printLinkedList(l3);
    }
}

