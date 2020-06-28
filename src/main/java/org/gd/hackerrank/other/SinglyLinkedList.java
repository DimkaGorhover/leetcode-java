package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;

@HackerRank(difficulty = HackerRank.Level.EASY)
class SinglyLinkedList {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        if (position == 0) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            node.next = head;
            return node;
        }

        SinglyLinkedListNode node = head;
        SinglyLinkedListNode next = head.next;
        while (position > 1 && next != null) {
            node = next;
            next = next.next;
            position--;
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        node.next = newNode;
        newNode.next = next;

        return head;

    }
}
