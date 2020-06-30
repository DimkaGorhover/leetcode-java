package org.gd.leetcode.p0019;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {
        LeetCode.Tags.LINKED_LIST,
        LeetCode.Tags.TWO_POINTERS
})
class Solution {

    private static int size(ListNode node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1))
            return null;

        if ((n = size(head) - n) == 0)
            return head.next;

        ListNode node = head, next;
        while ((next = node.next) != null && n > 1) {
            node = next;
            n--;
        }

        if (next != null)
            node.next = next.next;

        return head;
    }
}
