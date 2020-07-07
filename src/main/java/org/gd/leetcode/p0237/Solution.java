package org.gd.leetcode.p0237;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * @author Horkhover D.
 * @since 2020-07-07
 */
@LeetCode(
        name = "Delete Node in a Linked List",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
