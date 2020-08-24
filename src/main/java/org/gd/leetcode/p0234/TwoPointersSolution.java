package org.gd.leetcode.p0234;

import org.gd.leetcode.common.ListNode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-24
 */
class TwoPointersSolution implements Solution {

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
