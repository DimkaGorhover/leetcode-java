package org.gd.leetcode.p0096;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * @see org.gd.leetcode.p0206.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    private static ListNode reverseFromStart(ListNode head, int n) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        ListNode last = current;
        for (; current != null && n > 0; n--) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        last.next = current;
        return prev;
    }

    private static ListNode reverseFromPos(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        ListNode last = null;
        ListNode first = null;

        for (; m > 1 && current != null; m--, n--) {
            prev = current;
            current = current.next;
        }

        first = prev;
        last = current;
        prev = null;

        for (; current != null && n > 0; n--) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        first.next = prev;
        if (last != null)
            last.next = next;

        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n)
            return head;

        if (m == 1)
            return reverseFromStart(head, n);

        return reverseFromPos(head, m, n);
    }
}
