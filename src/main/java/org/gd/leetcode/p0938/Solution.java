package org.gd.leetcode.p0938;

import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/submissions/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (R < root.val) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
