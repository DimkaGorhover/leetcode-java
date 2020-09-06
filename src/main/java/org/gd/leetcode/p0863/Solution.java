package org.gd.leetcode.p0863;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * https://www.youtube.com/watch?v=nPtARJ2cYrg
 *
 * @author Horkhover Dmytro
 * @since 2020-09-06
 */
@LeetCode(
        name = "All Nodes Distance K in Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private TreeNode target;
    private Map<TreeNode, TreeNode> parents;
    private List<Integer> result;

    private TreeNode findTarget(TreeNode node, TreeNode parent) {
        if (node == null)
            return null;

        parents.put(node, parent);
        if (node.val == target.val)
            return node;

        TreeNode left = findTarget(node.left, node);
        if (left != null)
            return left;

        return findTarget(node.right, node);
    }

    private void findNodesOnDistance(TreeNode node, TreeNode prev, int distance) {
        if (distance < 0 || node == null)
            return;

        if (node != target && distance == 0) {
            result.add(node.val);
            return;
        }

        final int nextDistance = distance - 1;

        TreeNode left = node.left;
        if (left != null && left != prev && left != target)
            findNodesOnDistance(left, node, nextDistance);

        TreeNode right = node.right;
        if (right != null && right != prev && right != target)
            findNodesOnDistance(right, node, nextDistance);

        TreeNode parent = parents.get(node);
        if (parent != null && parent != prev && parent != node)
            findNodesOnDistance(parent, node, nextDistance);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null || K < 0)
            return Collections.emptyList();

        if (K == 0)
            return Collections.singletonList(target.val);

        this.target = target;
        parents = new HashMap<>();

        this.target = target = findTarget(root, null);
        if (target == null)
            return Collections.emptyList();

        result = new ArrayList<>();

        findNodesOnDistance(target, null, K);

        return result;
    }
}
