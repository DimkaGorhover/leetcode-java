package org.gd.leetcode.p0143;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0206.Solution
 * @since 2020-08-17
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        name = "Reorder List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return reverse(next);
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode right = split(head);
        ListNode left = head;

        while (right != null && left != null) {

            ListNode leftNext = left.next;
            ListNode rightNext = right.next;

            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }
    }
}
