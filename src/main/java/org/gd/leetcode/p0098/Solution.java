package org.gd.leetcode.p0098;

import org.gd.leetcode.common.TreeNode;

/**
 * TODO: https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class Solution {

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        if (root.left != null && root.left.val >= root.val)
            return false;

        if (root.right != null && root.right.val <= root.val)
            return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
