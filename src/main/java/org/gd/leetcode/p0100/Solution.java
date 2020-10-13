package org.gd.leetcode.p0100;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@LeetCode(
        name = "Same Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
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
