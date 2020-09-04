package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class FindMergePointTwoLinkedLists {

    private static int length(SinglyLinkedListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private static SinglyLinkedListNode skip(SinglyLinkedListNode head, int count) {
        while (count > 0 && head != null) {
            count--;
            head = head.next;
        }
        return head;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null)
            throw new NullPointerException("head1");

        if (head2 == null)
            throw new NullPointerException("head2");

        int length1 = length(head1);
        int length2 = length(head2);

        head1 = skip(head1, length1 - length2);
        head2 = skip(head2, length2 - length1);

        while (head1 != null && head2 != null) {

            if (head1 == head2) {
                return head1.data;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        throw new UnsupportedOperationException("not supported yet");
    }
}
