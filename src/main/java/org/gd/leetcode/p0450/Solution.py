# Task:
# https://leetcode.com/problems/delete-node-in-a-bst/
# 
# Iterative Solution:
# https://leetcode.com/problems/delete-node-in-a-bst/discuss/261868/
# 

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def find_min(slef, root: TreeNode) -> TreeNode:
        while root.left:
            root = root.left
        return root

    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if root:
            if key < root.val:
                root.left = self.deleteNode(root.left, key)
            elif key > root.val:
                root.right = self.deleteNode(root.right, key)
            else:
                if not root.left:
                    return root.right

                if not root.right:
                    return root.left

                min_node: TreeNode = self.find_min(root.right)
                root.val = min_node.val
                root.right = self.deleteNode(root.right, root.val)

        return root

