package org.gd.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * @author Gorkhover D.
 * @since 2018-10-23
 */
class TreeNode {

    int      val;
    TreeNode left;
    TreeNode right;

    static TreeNode of(Integer value) {
        return value == null ? null : new TreeNode(value);
    }

    static TreeNode of(Integer... values) {
        final TreeNode head  = new TreeNode(requireNonNull(values[0], "first value cannot be NULL"));
        List<TreeNode> nodes = List.of(head);
        int            i     = 1;
        while (!nodes.isEmpty()) {
            List<TreeNode> newNodes = new ArrayList<>(2);
            for (TreeNode node : nodes) {
                if (i < values.length) {
                    var tmp = of(values[i++]);
                    if (tmp != null) newNodes.add(tmp);
                    node.left = tmp;
                }
                if (i < values.length) {
                    var tmp = of(values[i++]);
                    if (tmp != null) newNodes.add(tmp);
                    node.right = tmp;
                }
            }
            nodes = newNodes;
        }
        return head;

    }

    TreeNode(int x) { val = x; }
}
