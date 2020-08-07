package org.gd.leetcode.p1290;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@LeetCode(
        name = "Convert Binary Number in a Linked List to Integer",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num = (num << 1) | head.val;
            head = head.next;
        }
        return num;
    }
}
