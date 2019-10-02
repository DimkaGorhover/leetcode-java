package org.gd.leetcode.p0617;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.TREE)
class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
