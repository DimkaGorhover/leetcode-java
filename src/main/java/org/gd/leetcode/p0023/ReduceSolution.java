package org.gd.leetcode.p0023;

import org.gd.leetcode.common.ListNode;

/**
 * @author Horkhover D.
 * @since 2020-07-13.07.2020
 */
class ReduceSolution extends Solution {

    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode node = null;
        for (ListNode list : lists) {
            node = mergeTwoLists(node, list);
        }
        return node;
    }
}
