package org.gd.leetcode.p0160;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@LeetCode(
        name = "Intersection of Two Linked Lists",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST
        }
)
interface Solution {

    ListNode getIntersectionNode(ListNode headA, ListNode headB);
}
