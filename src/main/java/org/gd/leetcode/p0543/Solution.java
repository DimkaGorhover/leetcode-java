package org.gd.leetcode.p0543;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-03
 */
@LeetCode(
        name = "Diameter of Binary Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE
        }
)
class Solution {

    private int max = 0;

    private int traverse(TreeNode root) {
        if (root == null)
            return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        max = Math.max(max, left + right);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        traverse(root);

        return max;
    }
}
