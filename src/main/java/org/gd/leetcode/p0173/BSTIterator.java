package org.gd.leetcode.p0173;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * @author Gorkhover D.
 * @since 2018-10-29
 */
class BSTIterator implements Comparator<TreeNode> {

    final ArrayList<TreeNode> nodes;

    int index;

    public BSTIterator(TreeNode root) {
        nodes = createNodes(new ArrayList<>(), root);
        nodes.sort(this);
        index = nodes.size() - 1;
    }

    private static ArrayList<TreeNode> createNodes(ArrayList<TreeNode> nodes, TreeNode node) {
        if (node == null)
            return nodes;
        nodes.add(node);
        createNodes(nodes, node.left);
        createNodes(nodes, node.right);
        return nodes;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index >= 0;
    }

    /** @return the next smallest number */
    public int next() {
        final TreeNode node = nodes.get(index);
        index--;
        return node.val;
    }

    @Override
    public int compare(TreeNode o1, TreeNode o2) {
        if (o1 == null)
            return o2 == null ? 0 : -1;
        return Integer.compare(o1.val, o2.val);
    }
}
