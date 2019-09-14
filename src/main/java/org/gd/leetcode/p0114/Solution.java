package org.gd.leetcode.p0114;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//@formatter:off
/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @author Horkhover Dmytro
 * @since 2019-01-03
 */
//@formatter:on
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        })
class Solution {

    /*
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    */

    private static void fill(TreeNode root, Queue<TreeNode> queue) {
        if (root != null) {
            queue.add(root);
            fill(root.left, queue);
            fill(root.right, queue);
        }
    }

    public void flatten(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        fill(root.left, queue);
        fill(root.right, queue);

        TreeNode head = root;
        while (!queue.isEmpty()) {
            head.right = queue.poll();
            head.left = null;
            head = head.right;
            head.left = null;
        }
    }
}
