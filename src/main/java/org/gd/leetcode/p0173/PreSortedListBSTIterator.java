package org.gd.leetcode.p0173;

import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Gorkhover D.
 * @since 2018-10-29
 */
class PreSortedListBSTIterator extends BSTIterator {

    private final ArrayList<Integer> nodes = new ArrayList<>();
    private int index;

    public PreSortedListBSTIterator(TreeNode root) {
        super(root);
        fulfill(root);
        nodes.sort(Integer::compare);
        index = 0;
    }

    private void fulfill(TreeNode node) {
        if (node != null) {
            nodes.add(node.val);
            fulfill(node.left);
            fulfill(node.right);
        }
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
