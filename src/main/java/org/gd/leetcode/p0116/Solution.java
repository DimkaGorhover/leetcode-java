package org.gd.leetcode.p0116;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeLinkNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author Horkhover Dmytro
 * @since 2019-01-03
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        })
class Solution {

    private static void connectByHashTable(Map<Integer, TreeLinkNode> map, TreeLinkNode next, int level) {
        if (next == null)
            return;
        map.compute(level, (l, prev) -> {
            if (prev != null)
                prev.next = next;
            return next;
        });
        connectByHashTable(map, next.left, level + 1);
        connectByHashTable(map, next.right, level + 1);
    }

    private static void connectByHashTable(TreeLinkNode root) {
        connectByHashTable(new HashMap<>(), root, 0);
    }

    private static void connectRecursive(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connectRecursive(root.left);
        connectRecursive(root.right);
    }

    public void connect(TreeLinkNode root) {
        connectRecursive(root);
    }
}
