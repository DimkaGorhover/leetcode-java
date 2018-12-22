package org.gd.leetcode.p0082;

import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0083.Solution
 * @since 2018-10-21
 */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode result = new ListNode(head.val - 1);
        result.next = head;

        ListNode
                prev = result,
                cur = prev.next,
                next = cur.next;

        int value = cur.val - 1;

        while (cur != null) {
            if (cur.val == value || (next != null && cur.val == next.val)) {
                prev.next = next;
                value = cur.val;
                cur = next;
                next = cur == null ? null : cur.next;
            } else {
                prev = prev.next;
                value = cur.val;
                cur = cur.next;
                next = next == null ? null : next.next;
            }
        }
        return result.next;
    }
}
