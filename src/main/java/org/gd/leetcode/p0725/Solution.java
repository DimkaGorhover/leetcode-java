package org.gd.leetcode.p0725;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@LeetCode(
        name = "Split Linked List in Parts",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.LINKED_LIST
        }
)
class Solution {

    private static int length(ListNode root) {
        int length = 0;
        while (root != null) {
            length++;
            root = root.next;
        }
        return length;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {

        final ListNode[] result = new ListNode[k];
        if (root == null)
            return result;

        int resultCursor = 0;

        final int length = length(root);
        final int elementsPerBatch = length / k;
        int extraElements = length % k;

        ListNode node = root;

        for (int ignored = 0; ignored < k; ignored++) {

            int n = elementsPerBatch;
            if (extraElements > 0) {
                extraElements--;
                n++;
            }

            if (n <= 0)
                break;

            for (int i = 0; i < n - 1; i++)
                node = node.next;

            ListNode next = node.next;
            node.next = null;
            result[resultCursor++] = root;
            root = node = next;
        }

        return result;
    }
}
