package org.gd.leetcode.p0148;

import org.gd.leetcode.common.ListNode;

import java.util.PriorityQueue;

/**
 * @author Horkhover Dmytro
 * @see PriorityQueue
 * @since 2020-10-13
 */
class HeapSolution implements Solution {

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    @Override
    public ListNode sortList(ListNode head) {
        final int length = length(head);
        if (length <= 1)
            return head;

        PriorityQueue<Integer> heap = new PriorityQueue<>(length);
        for (; head != null; head = head.next)
            heap.add(head.val);

        head = new ListNode(0);
        ListNode tmp = head;
        for (; !heap.isEmpty(); head = head.next)
            head.next = new ListNode(heap.poll());

        return tmp.next;
    }
}
