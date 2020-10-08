package org.gd.leetcode.p0701;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 *
 * @author Horkhover Dmytro
 * @since 2020-10-08
 */
@LeetCode(
        name = "Insert into a Binary Search Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TREE
)
class Solution {

    private static void insert(TreeNode node, int value) {

        // 1. if value already contains in BST
        if (value == node.val)
            return;

        // 2. if value is less than current node value -> go to left
        if (value < node.val) {

            if (node.left == null) {
                node.left = new TreeNode(value);
                return;
            }

            insert(node.left, value);
            return;
        }

        // 3. if value is bigger than current node value -> go to right
        if (node.right == null) {
            node.right = new TreeNode(value);
            return;
        }

        insert(node.right, value);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        insert(root, val);
        return root;
    }
}
