package org.gd.leetcode.p0113;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * @see org.gd.leetcode.p0112.Solution
 * @see org.gd.leetcode.p0257.Solution
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private List<List<Integer>> list;

    private void traverse(TreeNode root, List<Integer> pathValues, int pathSum, int target) {

        pathSum += root.val;
        pathValues.add(root.val);

        if (root.left == null && root.right == null && pathSum == target) {
            list.add(pathValues);
            return;
        }

        if (root.left != null)
            traverse(root.left, new ArrayList<>(pathValues), pathSum, target);

        if (root.right != null)
            traverse(root.right, pathValues, pathSum, target);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return Collections.emptyList();

        list = new ArrayList<>();
        traverse(root, new ArrayList<>(), 0, sum);
        return list;
    }
}
