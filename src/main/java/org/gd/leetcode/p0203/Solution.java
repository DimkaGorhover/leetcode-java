package org.gd.leetcode.p0203;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * <pre>
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * </pre>
 *
 * @since 2019-08-23
 */
@LeetCode(
        name = "Remove Linked List Elements",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
interface Solution {

    ListNode removeElements(ListNode head, int val);
}
