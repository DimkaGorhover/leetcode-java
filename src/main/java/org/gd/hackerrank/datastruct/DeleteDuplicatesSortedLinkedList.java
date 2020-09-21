package org.gd.hackerrank.datastruct;

import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;
import org.gd.leetcode.common.LeetCode;

/**
 * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-21
 */
@HackerRank(
        difficulty = HackerRank.Level.EASY,
        tags = LeetCode.Tags.LINKED_LIST
)
class DeleteDuplicatesSortedLinkedList {

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if (head == null)
            return null;

        SinglyLinkedListNode node = head;
        SinglyLinkedListNode next = node.next;
        while (next != null) {
            if (node.data != next.data) {
                node = next;
                next = next.next;
            } else {
                next = next.next;
                node.next = next;
            }
        }

        return head;
    }
}
