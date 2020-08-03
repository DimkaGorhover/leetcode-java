package org.gd.leetcode.p0116;

import org.gd.leetcode.common.TreeLinkNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Horkhover Dmytro
 * @see RecursiveSolution
 * @since 2020-08-03
 */
class HashTableSolution implements Solution {

    private Map<Integer, TreeLinkNode> map;

    private void connect(TreeLinkNode next, int level) {

        if (next == null)
            return;

        map.compute(level, (l, prev) -> {
            if (prev != null)
                prev.next = next;
            return next;
        });

        connect(next.left, level + 1);
        connect(next.right, level + 1);
    }

    public void connect(TreeLinkNode root) {
        map = new HashMap<>();
        connect(root, 0);
    }
}
