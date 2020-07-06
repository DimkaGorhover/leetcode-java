package org.gd.leetcode.p0147;

import org.gd.leetcode.common.ListNode;

class FastSolution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (head != null) {
            ListNode temp = head.next;
            if (pre.val > head.val) {
                pre = dummy;
            }
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
