package org.gd.leetcode.p1373;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0098.Solution
 * @since 2020-08-12
 */
@Repeat("Maximum Sum BST in Binary Tree")
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Maximum Sum BST in Binary Tree",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
interface Solution {

    int maxSumBST(TreeNode root);
}
