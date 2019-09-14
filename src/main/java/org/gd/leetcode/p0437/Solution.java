package org.gd.leetcode.p0437;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

//@formatter:off
/**
 * https://leetcode.com/problems/path-sum-iii/
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and
 * the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * @since 2019-09-14
 */
//@formatter:on
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.TREE)
class Solution {

    private static int pathSum0(final TreeNode node, final int expected) {
        return node == null ? 0 : (node.val == expected ? 1 : 0)
                + pathSum0(node.left, expected - node.val)
                + pathSum0(node.right, expected - node.val);

    }

    public int pathSum(final TreeNode root, final int expected) {
        return root == null ? 0 : pathSum0(root, expected)
                + pathSum(root.left, expected)
                + pathSum(root.right, expected);
    }
}
