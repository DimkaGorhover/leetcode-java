package org.gd.leetcode.p0382;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

import java.util.concurrent.ThreadLocalRandom;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@SuppressWarnings("ConstantConditions")
@LeetCode(
        name = "Linked List Random Node",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.RESERVOIR_SAMPLING
        }
)
class Solution {

    private final ListNode head;

    public Solution(ListNode head) {
        if (head == null)
            throw new NullPointerException();
        this.head = head;
    }

    public int getRandom() {
        ListNode result = null, current = head;
        for (int n = 1; current != null; n++) {
            if (ThreadLocalRandom.current().nextInt(n) == 0)
                result = current;
            current = current.next;
        }
        return result.val;
    }
}
