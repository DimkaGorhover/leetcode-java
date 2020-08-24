package org.gd.leetcode.p0025;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0096.Solution
 * @see org.gd.leetcode.p0206.Solution
 * @see org.gd.hackerrank.other.ReverseLinkedList
 * @since 2020-08-24
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Reverse Nodes in k-Group",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private static ListNode reverseList(final ListNode head,
                                        final int level,
                                        final int groupSize) {

        if (head == null || head.next == null || level == 0)
            return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        int i = groupSize;
        while (current != null && i > 0) {
            i--;
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head.next = reverseList(current, level - 1, groupSize);

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseList(head, length(head) / k, k);
    }
}
