package org.gd.leetcode.p1038;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0538.Solution
 * @since 2020-08-04
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Binary Search Tree to Greater Sum Tree",
        difficulty = LeetCode.Level.MEDIUM,
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

    public TreeNode bstToGst(TreeNode root) {

        if (root == null)
            return null;

        sum = 0;
        traverse(root);

        return root;
    }
}
