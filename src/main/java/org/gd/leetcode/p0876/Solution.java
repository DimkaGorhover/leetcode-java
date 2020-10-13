package org.gd.leetcode.p0876;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
@LeetCode(
        name = "Middle of the Linked List",
        state = LeetCode.State.DONE,
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.TWO_POINTERS
        }
)
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
