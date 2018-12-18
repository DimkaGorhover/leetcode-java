package org.gd.leetcode.p0101;

import org.gd.leetcode.common.TreeNode;

/**
 * TODO: https://leetcode.com/problems/symmetric-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class Solution {

    private static boolean isSymmetric0(TreeNode left, TreeNode right) {
        if (left == null)
            return right == null;
        if (right == null)
            return false;
        return left.val == right.val
                && isSymmetric0(left.left, right.right)
                && isSymmetric0(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric0(root.left, root.right);
    }
}
