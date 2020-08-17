package org.gd.leetcode.p1171;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
@LeetCode(
        name = "Remove Zero Sum Consecutive Nodes from Linked List",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.HASH_TABLE
        }
)
class Solution {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null)
            return null;

        Map<Integer, ListNode> sumToFarthestNodeMap = new HashMap<>();

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        int sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            sumToFarthestNodeMap.put(sum, p);
        }

        sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            p.next = sumToFarthestNodeMap.get(sum).next;
        }

        return preHead.next;
    }
}
