package org.gd.hackerrank.other;

import org.gd.common.Repeat;
import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;

/**
 * https://www.hackerrank.com/challenges/reverse-a-linked-list/
 *
 * @see org.gd.leetcode.p0096.Solution
 * @see org.gd.leetcode.p0206.Solution
 */
@SuppressWarnings("JavadocReference")
@Repeat("reverse linked list")
@HackerRank(difficulty = HackerRank.Level.EASY)
class ReverseLinkedList {

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = null;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;

            current = next;
        }
        head = prev;
        return head;
    }
}
