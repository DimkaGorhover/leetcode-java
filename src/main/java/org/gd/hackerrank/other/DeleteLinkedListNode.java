package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;

@HackerRank(difficulty = HackerRank.Level.EASY)
class DeleteLinkedListNode {

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null || position < 0)
            return head;

        if (position == 0)
            return head.next;

        SinglyLinkedListNode node = head;
        SinglyLinkedListNode next = node.next;

        while (next != null && position > 1) {
            node = next;
            next = node.next;
            position--;
        }

        if (node.next != null) 
            node.next = node.next.next;

        return head;
    }
}