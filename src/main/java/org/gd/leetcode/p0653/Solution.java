package org.gd.leetcode.p0653;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@LeetCode(
        name = "Two Sum IV - Input is a BST",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
class Solution {

    private Set<Integer> set;
    private int target;

    private boolean traverse(TreeNode node) {
        if (node == null)
            return false;

        if (set.contains(target - node.val))
            return true;

        set.add(node.val);

        return traverse(node.left) || traverse(node.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        set = new HashSet<>();
        target = k;

        return traverse(root);
    }
}
