package org.gd.leetcode.p0663;

import java.util.Stack;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * THIS IS NOT MY SOLUTION :(
 * 
 * https://leetcode.com/articles/equal-tree-partition/
 */
@Repeat("check if left and right nodes are equal")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = { LeetCode.Tags.TREE, LeetCode.Tags.BINARY_SEARCH_TREE })
class Solution {

    private Stack<Integer> seen;

    public boolean checkEqualTree(TreeNode root) {
        seen = new Stack<>();
        int total = sum(root);
        seen.pop();
        if (total % 2 == 0)
            for (int s : seen)
                if (s == total / 2)
                    return true;
        return false;
    }

    public int sum(TreeNode node) {
        if (node == null)
            return 0;
        seen.push(sum(node.left) + sum(node.right) + node.val);
        return seen.peek();
    }
}
