package org.gd.leetcode.p0129;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@LeetCode(
        name = "Sum Root to Leaf Numbers",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private int sum;

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void traverse(TreeNode root, int prev) {
        if (isLeaf(root)) {
            sum += prev;
            return;
        }

        if (root.left != null)
            traverse(root.left, prev * 10 + root.left.val);

        if (root.right != null)
            traverse(root.right, prev * 10 + root.right.val);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        sum = 0;
        traverse(root, root.val);
        return sum;
    }
}
