package org.gd.leetcode.p0098;

import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class Solution {

    private static boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return root == null || isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}
