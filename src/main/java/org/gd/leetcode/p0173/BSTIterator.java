package org.gd.leetcode.p0173;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * TODO: implement lazy iterator
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
abstract class BSTIterator {

    public BSTIterator(TreeNode root) {
    }

    /**
     * @return whether we have a next smallest number
     */
    public abstract boolean hasNext();

    /**
     * @return the next smallest number
     */
    public abstract int next();
}
