package org.gd.leetcode.p0203;

import org.gd.leetcode.common.ListNode;

class LoopSolution implements Solution {

    @Override
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || (head.next == null && head.val == val)) {
            return null;
        }

        // remove all head ListNode's if the contains target value
        while (head != null && head.val == val) {
            head = head.next;
        }

        for (ListNode _head = head; _head != null; ) {
            ListNode next = _head.next;
            if (next != null && next.val == val) {
                _head.next = next.next;
            } else {
                _head = next;
            }
        }
        return head;
    }
}
