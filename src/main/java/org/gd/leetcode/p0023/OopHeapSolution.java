package org.gd.leetcode.p0023;

import org.gd.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover D.
 * @since 2020-07-13
 */
class OopHeapSolution implements Solution {

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

        if (lists.length == 2)
            return mergeTwoLists(lists[0], lists[1]);

        final Heap heap = new Heap(lists);
        final ListNode head = heap.poll();
        ListNode node = head;
        for (ListNode next : heap)
            node = (node.next = next);

        return head;
    }

    static class Heap implements Comparator<ListNode>, Iterable<ListNode> {

        private final PriorityQueue<ListNode> heap;

        Heap(ListNode[] lists) {
            heap = new PriorityQueue<>(lists.length, this);
            for (ListNode list : lists)
                if (list != null)
                    heap.add(list);
        }

        ListNode poll() {
            ListNode node = heap.poll();
            if (node != null && node.next != null)
                heap.add(node.next);
            return node;
        }

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return Integer.compare(o1.val, o2.val);
        }

        @Override
        public Iterator<ListNode> iterator() {
            return new HeapItr(this);
        }
    }

    static class HeapItr implements Iterator<ListNode> {

        private final Heap heap;
        private ListNode next;

        HeapItr(Heap heap) {
            requireNonNull(heap, "\"heap\" cannot be null");
            this.heap = heap;
        }

        @Override
        public boolean hasNext() {
            return next != null || (next = heap.poll()) != null;
        }

        @Override
        public ListNode next() {
            if (!hasNext())
                throw new NoSuchElementException();

            ListNode next = this.next;
            this.next = null;
            return next;
        }
    }
}
