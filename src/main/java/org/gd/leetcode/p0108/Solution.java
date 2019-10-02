package org.gd.leetcode.p0108;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @see org.gd.leetcode.p0109.Solution
 * @since 2019-10-02
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY, tags = {LeetCode.Tags.TREE, LeetCode.Tags.DEPTH_FIRST_SEARCH})
class Solution {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return toTreeNode(nums, 0, nums.length);
    }
}
