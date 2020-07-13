package org.gd.leetcode.common;

class TreeNodeBuilder implements TreeNode.Builder {

    private final int val;
    private TreeNode left;
    private TreeNode right;

    TreeNodeBuilder(int val) {
        this.val = val;
    }

    @Override
    public TreeNode.Builder left(TreeNode node) {
        this.left = node;
        return this;
    }

    @Override
    public TreeNode.Builder right(TreeNode node) {
        this.right = node;
        return this;
    }

    @Override
    public TreeNode build() {
        TreeNode node = new TreeNode(val);
        node.left = left;
        node.right = right;
        return node;
    }
}
