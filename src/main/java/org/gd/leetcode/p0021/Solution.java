package org.gd.leetcode.p0021;

import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class Solution {

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
