package org.gd.leetcode.p0515;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
@LeetCode(
        name = "Find Largest Value in Each Tree Row",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.TREE
        }
)
interface Solution {

    List<Integer> largestValues(TreeNode root);
}
