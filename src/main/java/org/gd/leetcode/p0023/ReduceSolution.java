package org.gd.leetcode.p0023;

import org.gd.leetcode.common.ListNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Horkhover D.
 * @since 2020-07-13
 */
class ReduceSolution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        Collections.addAll(q, lists);

        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (!q.isEmpty()) {
            ListNode next = q.poll();
            if (node.next != null)
                q.add(node.next);
            node.next = next;
            node = next;
        }

        return head.next;
    }
}
