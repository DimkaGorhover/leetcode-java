package org.gd.leetcode.p0203;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @since 2019-08-23
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.LINKED_LIST)
class Solution {

    public ListNode removeElements(ListNode head, int val) {
        return removeLoop(head, val);
    }

    private static ListNode removeRecursive(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return removeRecursive(head.next, val);
        if (head.next != null && head.next.val == val)
            head.next = removeRecursive(head.next.next, val);
        head.next = removeRecursive(head.next, val);
        return head;
    }

    private static ListNode removeLoop(ListNode head, int val) {

        if (head == null || (head.next == null && head.val == val))
            return null;

        // remove all head ListNode's if the contains target value
        while (head != null && head.val == val)
            head = head.next;

        for (ListNode _head = head; _head != null; ) {
            ListNode next = _head.next;
            if (next != null && next.val == val) {
                _head.next = next.next;
            } else {
                _head = next;
            }
        }
        return head;
    }
}
