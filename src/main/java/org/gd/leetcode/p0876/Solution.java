package org.gd.leetcode.p0876;

import org.gd.leetcode.common.Difficulty;
import org.gd.leetcode.common.ListNode;

import static org.gd.leetcode.common.Difficulty.Level.EASY;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
@Difficulty(EASY)
class Solution {

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
