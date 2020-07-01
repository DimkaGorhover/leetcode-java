package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;

/**
 * https://www.hackerrank.com/challenges/compare-two-linked-lists/
 *
 * @author Horkhover D.
 * @since 2020-07-01
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class CompareTwoLinkedLists {

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == head2)
            return true;

        if (head1 == null || head2 == null)
            return false;

        return head1.data == head2.data && compareLists(head1.next, head2.next);
    }
}
