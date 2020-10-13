package org.gd.leetcode.p0083;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0082.Solution
 * @since 2018-10-21
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Remove Duplicates from Sorted List",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
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
