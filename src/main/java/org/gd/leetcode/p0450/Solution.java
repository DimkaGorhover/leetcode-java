package org.gd.leetcode.p0450;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
@Repeat("delete node from BST")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = { LeetCode.Tags.TREE, LeetCode.Tags.BINARY_SEARCH_TREE })
class Solution {

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }
}
