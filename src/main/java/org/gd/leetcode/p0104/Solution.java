package org.gd.leetcode.p0104;

import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class Solution {

    private static int maxDepth(TreeNode root, int deep) {
        return root == null
                ? deep - 1
                : Math.max(maxDepth(root.left, deep++), maxDepth(root.right, deep));
    }

    public int maxDepth(TreeNode root) { return maxDepth(root, 1); }
}
