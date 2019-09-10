package org.gd.leetcode.p0021;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.LINKED_LIST)
class Solution {

    @SuppressWarnings("DuplicatedCode")
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
