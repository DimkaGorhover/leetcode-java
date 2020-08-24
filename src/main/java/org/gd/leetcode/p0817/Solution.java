package org.gd.leetcode.p0817;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-components/
 *
 * Stupid Task
 *
 * @author Horkhover Dmytro
 * @since 2020-08-24
 */
@LeetCode(
        name = "Linked List Components",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    public int numComponents(ListNode head, int[] G) {
        if (head == null) return 0;
        if (head.next == null) return 1;
        Set<Integer> set = new HashSet<>(G.length);
        for (int i : G)
            set.add(i);
        ListNode node = head;
        int count = 0;
        while (node != null) {
            if (set.contains(node.val) && (node.next == null || !set.contains(node.next.val)))
                count++;
            node = node.next;
        }
        return count;
    }
}
