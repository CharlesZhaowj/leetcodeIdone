package com.pickbucket.leetcode.easy;

import com.pickbucket.leetcode.common.ListNode;

public class P_206_reverseList {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rest = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
