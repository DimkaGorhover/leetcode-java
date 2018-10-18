package org.gd.leetcode.p0024;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
 *
 * @author Gorkhover D.
 * @since 2018-10-18
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode newHead = null;
        ListNode prev    = null;
        ListNode n1      = head;
        ListNode n2      = n1.next;

        int i = 0;
        while (n2 != null) {
            if (i % 3 == 0) {
                if (prev != null)
                    prev.next = n2;
                prev = n1;
                n1.next = n2.next;
                n2.next = n1;
            }
            if (i == 0) {
                newHead = n2;
            }
            i++;
            n1 = n2;
            n2 = n1.next;
        }

        return newHead;
    }

}
