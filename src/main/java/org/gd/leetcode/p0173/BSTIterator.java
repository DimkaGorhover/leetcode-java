package org.gd.leetcode.p0173;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * @author Gorkhover D.
 * @since 2018-10-29
 */
@LeetCode(
        name = "Binary Search Tree Iterator",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.TREE,
                LeetCode.Tags.DESIGN
        })
class BSTIterator {

    private final ArrayList<Integer> nodes;
    private int index;

    public BSTIterator(TreeNode root) {
        nodes = createNodes(new ArrayList<>(), root);
        nodes.sort(Integer::compare);
        index = 0;
    }

    private static ArrayList<Integer> createNodes(ArrayList<Integer> nodes, TreeNode node) {
        if (node != null) {
            nodes.add(node.val);
            createNodes(nodes, node.left);
            createNodes(nodes, node.right);
        }
        return nodes;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() { return index < nodes.size(); }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return nodes.get(index++);
    }
}
