package org.gd.leetcode.p0104;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@LeetCode(difficulty = LeetCode.Level.EASY)
class Solution {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
