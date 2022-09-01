package org.gd.leetcode.p0002;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">LeetCode #2: Add Two Numbers</a>
 */
@LeetCode(
        name = "Add Two Numbers",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST,
                LeetCode.Tags.MATH
        })
class Solution {

    private static ListNode swap(ListNode res, int i) {
        ListNode tmp = new ListNode(i);
        res.next = tmp;
        return tmp;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;

        final ListNode head = new ListNode(0);

        ListNode tail = head;

        while (l1 != null || l2 != null) {
            sum = sum + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            tail = swap(tail, sum % 10);
            sum /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (sum != 0) {
            swap(tail, sum);
        }

        return head.next;
    }
}
