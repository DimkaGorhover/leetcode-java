package org.gd.leetcode.p0572;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * @see org.gd.leetcode.p1367.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Subtree of Another Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private boolean dfs(TreeNode s, TreeNode t) {
        if (t == null) return s == null;
        if (s == null) return false;
        return s.val == t.val
                && dfs(s.left, t.left)
                && dfs(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return s == null;
        if (s == null) return false;

        return dfs(s, t)
                || isSubtree(s.left, t)
                || isSubtree(s.right, t);
    }
}
