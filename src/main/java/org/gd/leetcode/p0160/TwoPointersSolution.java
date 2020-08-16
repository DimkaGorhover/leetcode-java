package org.gd.leetcode.p0160;

import org.gd.leetcode.common.ListNode;

/**
 * @author Horkhover Dmytro
 * @see HashTableSolution
 * @since 2020-08-16
 */
class TwoPointersSolution implements Solution {

    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private static ListNode skip(ListNode node, int skipCount) {
        while (node != null && skipCount > 0) {
            node = node.next;
            skipCount--;
        }
        return node;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        final int lengthA = length(headA);
        final int lengthB = length(headB);

        headA = skip(headA, lengthA - lengthB);
        headB = skip(headB, lengthB - lengthA);

        while (headA != null && headB != null) {

            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
