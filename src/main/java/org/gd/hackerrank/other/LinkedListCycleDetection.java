package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;
import org.gd.hackerrank.common.SinglyLinkedListNode;
import org.gd.leetcode.common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0141.Solution
 * @since 2020-07-01
 */
@SuppressWarnings("JavadocReference")
@HackerRank(
        difficulty = HackerRank.Level.MEDIUM,
        tags = {
                LeetCode.Tags.LINKED_LIST
        })
class LinkedListCycleDetection {

    static boolean hasCycle(SinglyLinkedListNode head) {
        for (Set<SinglyLinkedListNode> nodesSeen = new HashSet<>(); head != null; head = head.next) {
            if (nodesSeen.contains(head))
                return true;
            nodesSeen.add(head);
        }
        return false;
    }
}
