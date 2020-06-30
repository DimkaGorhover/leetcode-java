# https://leetcode.com/problems/binary-tree-pruning/

class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    
    def pruneTree(self, root: TreeNode) -> TreeNode:
        if root:
            self.prune_left(root, root.left)
            self.prune_right(root, root.right)

        return root

    def prune_left(self, parent: TreeNode, node: TreeNode):

        if node:
            self.prune_left(node, node.left)
            self.prune_right(node, node.right)
            
            if not node.left and not node.right and node.val == 0:
                parent.left = None

    def prune_right(self, parent: TreeNode, node: TreeNode):

        if node:
            self.prune_left(node, node.left)
            self.prune_right(node, node.right)
            
            if not node.left and not node.right and node.val == 0:
                parent.right = None

