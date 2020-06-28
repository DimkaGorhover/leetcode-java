package org.gd.hackerrank.other;

import org.gd.common.Repeat;
import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;

@Repeat
@HackerRank(difficulty = HackerRank.Level.EASY)
class ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println(reverse(SinglyLinkedListNode.of(1, 2, 3, 4)));
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null)
            return null;

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
