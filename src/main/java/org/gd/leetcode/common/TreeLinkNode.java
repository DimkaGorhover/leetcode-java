package org.gd.leetcode.common;

import java.util.Objects;

/**
 * @author Horkhover Dmytro
 * @since 2019-01-03
 */
public class TreeLinkNode {

    public final int val;

    public TreeLinkNode left, right, next;

    TreeLinkNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeLinkNode)) return false;
        TreeLinkNode that = (TreeLinkNode) o;
        return val == that.val
                && Objects.equals(left, that.left)
                && Objects.equals(right, that.right)
                && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right, next);
    }
}
