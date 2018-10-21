package org.gd.leetcode.p0082;

import lombok.EqualsAndHashCode;

/**
 * @author Gorkhover D.
 * @since 2018-10-21
 */
@EqualsAndHashCode(doNotUseGetters = true)
class ListNode {

    int      val;
    ListNode next;

    ListNode(int x) { val = x; }

    static ListNode of(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode node = head;
        for (int i = 1; i < values.length; i++) {
            ListNode tmp = new ListNode(values[i]);
            node.next = tmp;
            node = tmp;
        }
        return head;
    }

    @Override
    public String toString() {
        return val + (next == null ? "" : " -> " + next);
    }
}
