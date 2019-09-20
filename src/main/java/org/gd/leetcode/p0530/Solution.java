package org.gd.leetcode.p0530;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.*;

//@formatter:off
/**
 * FIXME: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output: 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 * Note: There are at least two nodes in this BST.
 *
 * @since 2019-09-14
 */
//@formatter:on
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.TREE)
class Solution {

    /*
class Solution {
    private TreeNode prev = null;
    private int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (prev == null) {
            prev = root;
        } else {
            res = Math.min(res, root.val - prev.val);
            prev = root;
        }

        getMinimumDifference(root.right);
        return res;
    }
}
     */

    private static void fill(TreeNode node, Collection<Integer> list) {
        if (node != null) {
            list.add(node.val);
            fill(node.left, list);
            fill(node.right, list);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        fill(root, integers);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i + 1; j < integers.size(); j++) {
                min = Math.min(min, Math.abs(integers.get(i) - integers.get(j)));
            }
        }
        return min;
    }
}
