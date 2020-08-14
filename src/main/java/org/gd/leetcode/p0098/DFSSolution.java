package org.gd.leetcode.p0098;

import org.gd.leetcode.common.TreeNode;

class DFSSolution implements Solution {

    private static boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null)
            return true;

        if (root.val >= max || root.val <= min)
            return false;

        return isValidBST(root.left, root.val, min)
                && isValidBST(root.right, max, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}
