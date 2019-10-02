package org.gd.leetcode.p0109;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.ListNode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @see org.gd.leetcode.p0108.Solution
 * @since 2019-10-02
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.LINKED_LIST, LeetCode.Tags.DEPTH_FIRST_SEARCH})
class Solution {

    private static int length(ListNode head) {
        if (head == null)
            return 0;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    private static int[] toArray(ListNode head, int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = head.val;
            head = head.next;
        }
        return arr;
    }

    @SuppressWarnings("DuplicatedCode")
    private static TreeNode toTreeNode(int[] arr, int startIndex, int endIndex) {
        int length = endIndex - startIndex;
        switch (length) {
            case 0: return null;
            case 1: return new TreeNode(arr[startIndex]);
            case 2: {
                TreeNode treeNode = new TreeNode(arr[startIndex + 1]);
                treeNode.left = new TreeNode(arr[startIndex]);
                return treeNode;
            }
            case 3: {
                TreeNode treeNode = new TreeNode(arr[startIndex + 1]);
                treeNode.left = new TreeNode(arr[startIndex]);
                treeNode.right = new TreeNode(arr[startIndex + 2]);
                return treeNode;
            }
        }
        final int mid = startIndex + (length >> 1);
        TreeNode treeNode = new TreeNode(arr[mid]);
        treeNode.left = toTreeNode(arr, startIndex, mid);
        treeNode.right = toTreeNode(arr, mid + 1, endIndex);
        return treeNode;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int length = length(head);
        switch (length) {
            case 0: return null;
            case 1: return new TreeNode(head.val);
            case 2: {
                TreeNode treeNode = new TreeNode(head.next.val);
                treeNode.left = new TreeNode(head.val);
                return treeNode;
            }
            case 3: {
                TreeNode treeNode = new TreeNode(head.next.val);
                treeNode.left = new TreeNode(head.val);
                treeNode.right = new TreeNode(head.next.next.val);
                return treeNode;
            }
        }
        int[] ints = toArray(head, length);
        return toTreeNode(ints, 0, ints.length);
    }
}
