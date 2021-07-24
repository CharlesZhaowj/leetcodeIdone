package com.pickbucket.leetcode.common;

public class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode createList(int[] num) {
        if (num == null) {
            return null;
        }
        ListNode head = new ListNode(num[0]);
        ListNode curr = head;
        for (int i = 1; i < num.length; i++) {
            curr.next = new ListNode(num[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val + " ");
            curr = curr.next;
        }
    }
}