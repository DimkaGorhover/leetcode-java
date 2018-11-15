package org.gd.leetcode.p0098;

import org.gd.leetcode.common.TreeNode;

/**
 * TODO: https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class Solution {

    private static boolean isValidBST(TreeNode root, int min, int max) {

        throw new UnsupportedOperationException();
    }

    public boolean isValidBST(TreeNode root) {
        return root == null || isValidBST(root, root.val, root.val);
    }
}
