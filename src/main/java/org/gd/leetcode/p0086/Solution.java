package org.gd.leetcode.p0086;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 *
 * @author Gorkhover D.
 * @since 2018-10-23
 */
@LeetCode(
        name = "Partition List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.TWO_POINTERS
        })
class Solution {

    public ListNode partition(ListNode head, int x) {

        ListNode before = new ListNode(0);
        ListNode newHead = before;
        ListNode after = new ListNode(0);
        ListNode tail = after;

        while (head != null) {

            ListNode next = head.next;

            if (head.val < x) {
                before.next = head;
                before = head;
                before.next = null;
            } else {
                after.next = head;
                after = head;
                after.next = null;
            }

            head = next;
        }

        before.next = tail.next;

        return newHead.next;
    }
}
