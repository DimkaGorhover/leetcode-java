package org.gd.leetcode.p0100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class TreeNode {

    int      val;
    TreeNode left;
    TreeNode right;

    static TreeNode of(int... values) {
        final TreeNode head  = new TreeNode(values[0]);
        List<TreeNode> nodes = List.of(head), newNodes;
        TreeNode       tmp;
        int            i     = 0;
        while (!nodes.isEmpty() && i < values.length) {
            newNodes = new ArrayList<>(2);
            for (TreeNode node : nodes) {
                if (i < values.length) {
                    newNodes.add(tmp = new TreeNode(values[i]));
                    node.left = tmp;
                    i++;
                }
                if (i < values.length) {
                    newNodes.add(tmp = new TreeNode(values[i]));
                    node.right = tmp;
                    i++;
                }
            }
            nodes = newNodes;
        }
        return head;
    }

    TreeNode(int x) { val = x; }
}
