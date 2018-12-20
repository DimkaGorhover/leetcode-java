package org.gd.leetcode.p0104;

import org.gd.leetcode.common.Difficulty;
import org.gd.leetcode.common.TreeNode;

import static org.gd.leetcode.common.Difficulty.Level.EASY;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
@Difficulty(EASY)
class Solution {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
