package org.gd.leetcode.p0206;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @see org.gd.leetcode.p0025.Solution
 * @see org.gd.leetcode.p0096.Solution
 * @see org.gd.hackerrank.other.ReverseLinkedList
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Reverse Linked List",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    public ListNode reverseList(ListNode head) {
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
}
