package com.pickbucket.leetcode.hard;

import com.pickbucket.leetcode.common.ListNode;

/**
 * k个一组，反转链表
 */
public class P_25_reverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        int i = 0;
        ListNode curr = head;
        ListNode start = head;
        while(curr != null) {
            i++;
            if (i == k) {

            }
        }
        return null;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
