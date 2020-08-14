package org.gd.leetcode.p0098;

import org.gd.leetcode.common.TreeNode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class BFSSolution implements Solution {

    public boolean isValidBST(TreeNode root) {
        return false;
    }

    static class Entry {
        private final TreeNode node;

        Entry(TreeNode node, int min, int max) {
            this.node = node;
        }
    }
}
