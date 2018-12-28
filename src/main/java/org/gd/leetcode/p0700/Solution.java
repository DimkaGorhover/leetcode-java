package org.gd.leetcode.p0700;

import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-28
 */
class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        return root == null || root.val == val
                ? root
                : searchBST(root.val < val ? root.right : root.left, val);
    }
}
