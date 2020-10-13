package org.gd.leetcode.p0148;

import org.gd.leetcode.common.ListNode;

/**
 * @author Dmytro Horkhover
 * @since 2020-10-13
 */
class OnPlaceSolution implements Solution {

    private ListNode head1, head2;

    @Override
    public ListNode sortList(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        split(head);

        ListNode head1 = this.head1;
        ListNode head2 = this.head2;

        head1 = sortList(head1);
        head2 = sortList(head2);

        return merge(head1, head2);
    }

    private void split(ListNode head) {

        head1 = null;
        head2 = null;

        ListNode slow = head;
        ListNode fast = slow.next;

        if (fast == null) {
            head1 = head;
            return;
        }

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        head1 = head;
        head2 = slow.next;
        slow.next = null;
    }

    private ListNode merge(ListNode head1, ListNode head2) {

        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode node = new ListNode(0);
        ListNode head = node;

        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                node.next = head2;
                head2 = head2.next;
            } else {
                node.next = head1;
                head1 = head1.next;
            }
            node = node.next;
        }

        if (head1 != null)
            node.next = head1;

        if (head2 != null)
            node.next = head2;

        return head.next;
    }
}
