package org.gd.leetcode.p0637;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
@LeetCode(
        name = "Average of Levels in Binary Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.TREE
        }
)
class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {

                TreeNode node = bfs.poll();

                sum += node.val;

                if (node.left != null)
                    bfs.add(node.left);

                if (node.right != null)
                    bfs.add(node.right);
            }
            result.add(((double) sum) / size);
        }
        return result;
    }
}
