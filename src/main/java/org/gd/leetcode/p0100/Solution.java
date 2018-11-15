package org.gd.leetcode.p0100;

/**
 * https://leetcode.com/problems/same-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;

        if (p != null) {
            if (q == null)
                return false;

            if (p.val == q.val)
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}
