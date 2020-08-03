package org.gd.leetcode.p1522;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/diameter-of-n-ary-tree/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.common.TreeNode
 * @see org.gd.leetcode.p0543.Solution
 * @since 2020-08-03
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Diameter of N-Ary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.PAID,
        tags = {
                LeetCode.Tags.TREE
        }
)
class Solution {

    private int max = 0;

    private int traverse(Node root) {
        if (root == null)
            return 0;

        if (root.children == null || root.children.length == 0)
            return 1;

        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < root.children.length; i++) {
            int result = traverse(root.children[i]);
            if (result > max1) {
                max2 = max1;
                max1 = result;
            } else if (result > max2) {
                max2 = result;
            }
        }

        max = Math.max(max, max1 + max2);

        return 1 + max1;
    }

    public int diameterOfNaryTree(Node root) {
        if (root == null)
            return 0;

        traverse(root);

        return max;
    }

    static class Node {
        int val;
        Node[] children;

        Node(int val) {
            this.val = val;
        }
    }
}
