package org.gd.leetcode.p0141;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Horkhover D.
 * @see org.gd.hackerrank.other.LinkedListCycleDetection
 * @since 2020-07-01
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.TWO_POINTERS
        }
)
class Solution {

    private static boolean hashTable(ListNode head) {
        for (Set<ListNode> nodesSeen = new HashSet<>(); head != null; head = head.next) {
            if (nodesSeen.contains(head))
                return true;
            nodesSeen.add(head);
        }
        return false;
    }

    private static boolean twoPointers(ListNode head) {
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

    public boolean hasCycle(ListNode head) {
        return twoPointers(head);
    }
}
