package org.gd.leetcode.p0235;


/*
-------------------------------------------------------------------------------
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int s = p.val;
        int b = q.val;
        if (s > b) {
            s = q.val;
            b = p.val;
        }
        while (root != null && (root.val > b || root.val < s)) {
            if (root.val > b) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
-------------------------------------------------------------------------------
 */

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * @author Gorkhover D.
 * @since 2018-10-17
 */
class Solution {

    private static RTreeNode traversing0(RTreeNode parent, TreeNode node, int value) {
        if (node == null)
            return null;
        final RTreeNode currentParent, leftParent, rightParent;
        if ((currentParent = new RTreeNode(parent, node)).val() == value)
            return currentParent;
        if ((rightParent = traversing0(currentParent, node.right, value)) != null && rightParent.val() == value)
            return rightParent;
        if ((leftParent = traversing0(currentParent, node.left, value)) != null && leftParent.val() == value)
            return leftParent;
        return null;
    }

    private static TreeNode traversing(TreeNode node, int p, int q) {
        RTreeNode rTreeNode1 = traversing0(null, node, p);
        RTreeNode rTreeNode2 = traversing0(null, node, q);

        while (rTreeNode1.val() != rTreeNode2.val()) {
            if (rTreeNode1.level < rTreeNode2.level) {
                rTreeNode2 = rTreeNode2.parent;
            } else if (rTreeNode1.level > rTreeNode2.level) {
                rTreeNode1 = rTreeNode1.parent;
            } else {
                rTreeNode1 = rTreeNode1.parent;
                rTreeNode2 = rTreeNode2.parent;
            }
        }

        return rTreeNode1.val;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        return traversing(root, p.val, q.val);
    }

    static class RTreeNode {
        final RTreeNode parent;
        final TreeNode  val;
        final int       level;

        RTreeNode(RTreeNode parent, TreeNode val) {
            if (val == null)
                throw new NullPointerException("val");
            this.parent = parent;
            this.val = val;
            this.level = parent == null ? 0 : parent.level + 1;
        }

        int val() { return val.val; }

        @Override
        public String toString() {
            return (parent == null ? "R_Root_Node" : "R_Tree_Node") +
                    "{val=" + val.val + ", level=" + level + '}';
        }
    }

}
