package org.gd.leetcode.p0023;

import org.gd.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Horkhover D.
 * @see OopHeapSolution
 * @since 2020-07-13
 */
class HeapSolution implements Solution {

    @SuppressWarnings("DuplicatedCode")
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists)
            if (list != null)
                q.add(list);

        ListNode head = new ListNode(-1), node = head, next;
        while ((next = q.poll()) != null) {
            if (next.next != null)
                q.add(next.next);
            node.next = next;
            node = next;
        }

        return head.next;
    }
}
