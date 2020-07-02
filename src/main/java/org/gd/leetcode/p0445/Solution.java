package org.gd.leetcode.p0445;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.LINKED_LIST
)
class Solution {

    private static int size(ListNode node) {
        if (node == null)
            return 0;
        int size = 1;
        while ((node = node.next) != null)
            size++;
        return size;
    }

    private static ListNode sumRecursive(ListNode l1, ListNode l2) {
        if (l1.next == null)
            return new ListNode(l1.val + l2.val);

        ListNode nextNode = sumRecursive(l1.next, l2.next);

        int nextSum = nextNode.val;
        nextNode.val = nextSum % 10;

        ListNode node = new ListNode((nextSum / 10) + l1.val + l2.val);
        node.next = nextNode;
        return node;
    }

    private static ListNode extendsLast(ListNode node) {
        if (node.val < 10)
            return node;

        int nextSum = node.val;
        node.val = nextSum % 10;

        ListNode newNode = new ListNode(nextSum / 10);
        newNode.next = node;
        return newNode;
    }

    private static ListNode addZeros(ListNode node, int size, int target) {
        while (size < target) {
            ListNode zero = new ListNode(0);
            zero.next = node;
            node = zero;
            size++;
        }
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int size1 = size(l1);
        int size2 = size(l2);

        return extendsLast(sumRecursive(
                addZeros(l1, size1, size2),
                addZeros(l2, size2, size1)));
    }
}
