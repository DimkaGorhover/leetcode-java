package org.gd.leetcode.p0559;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
@LeetCode(
        name = "Maximum Depth of N-ary Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    public int maxDepth(Node root) {

        if (root == null)
            return 0;

        if (root.children == null || root.children.isEmpty())
            return 1;

        int max = 0;
        for (Node child : root.children)
            max = Math.max(max, maxDepth(child));

        return max + 1;
    }
}
