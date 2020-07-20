package org.gd.leetcode.p0662;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-20
 */
@LeetCode(
        name = "Maximum Width of Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.TREE
        }
)
interface Solution {

    int widthOfBinaryTree(TreeNode root);
}
