package org.gd.leetcode.p0024;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * @author Gorkhover D.
 * @since 2018-10-18
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.LINKED_LIST)
class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode newHead = null, prev = null, n1 = head, n2 = n1.next;

        int i = 0;
        while (n2 != null) {
            if (i % 3 == 0) {
                if (prev != null)
                    prev.next = n2;
                prev = n1;
                n1.next = n2.next;
                n2.next = n1;
            }
            if (i == 0) {
                newHead = n2;
            }
            i++;
            n1 = n2;
            n2 = n1.next;
        }

        return newHead;
    }

}
