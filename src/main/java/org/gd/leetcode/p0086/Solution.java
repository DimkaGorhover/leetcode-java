package org.gd.leetcode.p0086;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * TODO: https://leetcode.com/problems/partition-list/
 *
 * @author Gorkhover D.
 * @since 2018-10-23
 */
@LeetCode(
        name = "Partition List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.TWO_POINTERS
        })
class Solution {

    private static void insertNext(ListNode node, ListNode next) {
        next.next = node.next;
        node.next = next;
    }

    public ListNode partition(ListNode head, int x) {

        ListNode pivot = head;
        ListNode beforePivot = null;

        // try to find "x"
        while (pivot != null && pivot.val != x) {
            beforePivot = pivot;
            pivot = pivot.next;
        }

        // "x" is not found
        if (pivot == null)
            return head;

        ListNode prev = beforePivot;
        ListNode node = pivot;
        while (node != null) {

            ListNode next = node.next;

            if (node.val < x) {

                prev.next = next;

                beforePivot.next = node;
                node.next = pivot;

                beforePivot = node;
            }

            prev = node;
            node = next;
        }


        return head;
    }
}
