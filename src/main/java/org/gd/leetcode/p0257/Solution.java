package org.gd.leetcode.p0257;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * @see org.gd.leetcode.p0112.Solution
 * @see org.gd.leetcode.p0113.Solution
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private final StringBuilder buffer = new StringBuilder();

    private List<String> result = Collections.emptyList();

    private void traverse(TreeNode node, String prefix) {
        buffer.append(prefix).append(node.val);

        if (node.left == null && node.right == null) {
            result.add(buffer.toString());
            return;
        }

        int bufferLength = buffer.length();
        prefix = "->";

        if (node.left != null) {
            buffer.setLength(bufferLength);
            traverse(node.left, prefix);
        }

        if (node.right != null) {
            buffer.setLength(bufferLength);
            traverse(node.right, prefix);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        result = new ArrayList<>();
        buffer.setLength(0);

        traverse(root, "");
        return result;
    }
}
