package org.gd.leetcode.p0147;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
@LeetCode(
        name = "Insertion Sort List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.SORT
        })
class Solution {

    private static ListNode insert(ListNode head, int val) {
        if (val < head.val) {
            ListNode node = new ListNode(val);
            node.next = head;
            return node;
        }
        ListNode parent = head;
        ListNode next = parent.next;
        while (next != null && next.val <= val) {
            parent = next;
            next = next.next;
        }
        (parent.next = new ListNode(val)).next = next;
        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head.next;
        head = new ListNode(head.val);
        while (node != null) {
            head = insert(head, node.val);
            node = node.next;
        }
        return head;
    }
}
