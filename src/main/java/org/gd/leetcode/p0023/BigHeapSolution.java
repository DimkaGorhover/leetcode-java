package org.gd.leetcode.p0023;

import org.gd.leetcode.common.ListNode;

import java.util.PriorityQueue;

@Deprecated
@SuppressWarnings("JavadocReference")
class BigHeapSolution implements Solution {

    /**
     * @see org.gd.leetcode.p0021.Solution#mergeTwoLists(ListNode, ListNode)
     */
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

        if (lists == null)
            return null;

        switch (lists.length) {
            case 0: return null;
            case 1: return lists[0];
            case 2: return mergeTwoLists(lists[0], lists[1]);
            case 3: return mergeTwoLists(mergeTwoLists(lists[0], lists[1]), lists[2]);
            case 4: return mergeTwoLists(mergeTwoLists(lists[0], lists[3]), mergeTwoLists(lists[1], lists[2]));
            case 8: return mergeTwoLists(
                    mergeTwoLists(
                            mergeTwoLists(lists[0], lists[3]),
                            mergeTwoLists(lists[1], lists[2])),
                    mergeTwoLists(
                            mergeTwoLists(lists[4], lists[7]),
                            mergeTwoLists(lists[5], lists[6])));
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (ListNode head : lists)
            for (; head != null; head = head.next)
                heap.add(head.val);

        ListNode tmp = new ListNode(0);
        for (ListNode head = tmp; !heap.isEmpty(); head = head.next)
            head.next = new ListNode(heap.poll());

        return tmp.next;
    }
}
