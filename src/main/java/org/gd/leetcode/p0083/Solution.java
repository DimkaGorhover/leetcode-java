package org.gd.leetcode.p0083;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0082.Solution
 * @since 2018-10-21
 */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head, cur = prev.next, next;

        while (cur != null) {
            next = cur.next;
            if (prev.val == cur.val) {
                prev.next = next;
                cur = next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
