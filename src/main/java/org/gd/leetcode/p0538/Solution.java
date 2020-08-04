package org.gd.leetcode.p0538;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p1038.Solution
 * @since 2020-08-04
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Convert BST to Greater Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
class Solution {

    private int sum = 0;

    private void traverse(TreeNode node) {
        if (node == null)
            return;
        traverse(node.right);
        node.val = (sum += node.val);
        traverse(node.left);
    }

    public TreeNode convertBST(TreeNode root) {

        if (root == null)
            return null;

        sum = 0;
        traverse(root);

        return root;
    }
}
