package org.gd.hackerrank.datastruct;

import org.gd.hackerrank.common.DoublyLinkedListNode;
import org.gd.hackerrank.common.HackerRank;
import org.gd.leetcode.common.LeetCode;

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-04
 */
@HackerRank(
        difficulty = HackerRank.Level.EASY,
        tags = LeetCode.Tags.LINKED_LIST
)
class ReverseDoublyLinkedList {

    private static void connect(DoublyLinkedListNode prev, DoublyLinkedListNode next) {
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
    }

    private static void unlink(DoublyLinkedListNode node) {
        if (node == null)
            return;

        DoublyLinkedListNode prev = node.prev;
        DoublyLinkedListNode next = node.next;

        if (prev != null) {
            prev.next = next;
            node.prev = null;
        }

        if (next != null) {
            next.prev = prev;
            node.next = null;
        }
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null)
            return null;

        if (head.prev != null)
            throw new IllegalStateException("head should not have \"prev\"");

        if (head.next == null)
            return head;

        DoublyLinkedListNode tail = null;
        while (head != null) {
            DoublyLinkedListNode next = head.next;
            unlink(head);
            connect(head, tail);
            tail = head;
            head = next;
        }

        return tail;
    }
}
