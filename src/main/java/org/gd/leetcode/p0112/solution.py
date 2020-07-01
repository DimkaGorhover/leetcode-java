class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def hasPathSum(self, root: TreeNode, target_sum: int) -> bool:

        def traverse(node: TreeNode, path_sum: int) -> bool:
            path_sum += node.val
            if not node.left and not node.right:
                return target_sum == path_sum

            return (node.left and traverse(node.left, path_sum)) or (node.right and traverse(node.right, path_sum))

        return root and traverse(root, 0)
