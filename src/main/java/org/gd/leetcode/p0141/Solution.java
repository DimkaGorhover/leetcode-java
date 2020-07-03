package org.gd.leetcode.p0141;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author Horkhover D.
 * @see org.gd.hackerrank.other.LinkedListCycleDetection
 * @since 2020-07-01
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Linked List Cycle",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.TWO_POINTERS
        }
)
class Solution {

    private final SolutionProvider solution = new TwoPointersSolution();

    public boolean hasCycle(ListNode head) {
        return solution.hasCycle(head);
    }

    interface SolutionProvider {

        boolean hasCycle(ListNode head);
    }

    static class TwoPointersSolution implements SolutionProvider {

        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null)
                return false;

            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null)
                    return false;
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

    static class HashTableSolution implements SolutionProvider {

        @Override
        public boolean hasCycle(ListNode head) {
            for (Set<ListNode> nodesSeen = new HashSet<>(); head != null; head = head.next) {
                if (nodesSeen.contains(head))
                    return true;
                nodesSeen.add(head);
            }
            return false;
        }
    }
}
