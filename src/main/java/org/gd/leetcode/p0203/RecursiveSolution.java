package org.gd.leetcode.p0203;

import org.gd.leetcode.common.ListNode;

class RecursiveSolution implements Solution {

    @Override
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements(head.next, val);
        }

        if (head.next != null && head.next.val == val) {
            head.next = removeElements(head.next.next, val);
        }

        head.next = removeElements(head.next, val);
        return head;
    }
}
