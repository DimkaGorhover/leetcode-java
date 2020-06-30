package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;

/**
 * FIXME: https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class FindMergePointTwoLinkedLists {
    
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null)
            throw new NullPointerException("head1");
            
        if (head2 == null)
            throw new NullPointerException("head2");

        Finder finder = new Finder();
        finder.findMergeNode(head1.next, head2.next);
        return finder.get();
    }

    static class Finder {

        int value = -1;

        boolean findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            return findMergeNode0(head1, head2);
        }

        boolean findMergeNode0(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            if (head1 == null || head2 == null) {
                return false;
            }

            if (head1.data == head2.data) {
                value = head1.data;
                return true;
            }
            return findMergeNode1(head1, head2.next) || findMergeNode0(head1.next, head2);
        }

        boolean findMergeNode1(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            if (head1 == null || head2 == null) {
                return false;
            }

            if (head1.data == head2.data) {
                value = head1.data;
                return true;
            }
            return findMergeNode0(head1, head2.next) || findMergeNode1(head1.next, head2);
        }

        int get() {
            return value;
        }
    }
}