package org.gd.hackerrank.datastruct;

import org.gd.hackerrank.common.DoublyLinkedListNode;
import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/
 *
 * @author Horkhover Dmytro
 * @since 2020-10-06
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class InsertingNodeSortedDoublyLinkedList {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (head == null) {
            return new DoublyLinkedListNode(data);
        }

        if (head.data >= data) {
            DoublyLinkedListNode newHead = new DoublyLinkedListNode(data);
            newHead.next = head;
            head.prev = newHead;
            return newHead;
        }

        DoublyLinkedListNode next = head;
        DoublyLinkedListNode prev = head.prev;

        while (next != null && next.data <= data) {
            prev = next;
            next = next.next;
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        node.next = next;
        node.prev = prev;
        prev.next = node;
        if (next != null) {
            next.prev = node;
        }

        return head;
    }
}
