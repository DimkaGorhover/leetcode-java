class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def __init__(self):
        self.result_list = []

    def pathSum(self, root: TreeNode, target_sum: int) -> List[List[int]]:

        if not root:
            return []

        def traverse(node: TreeNode, path: List[int], path_sum: int):
            path_sum += node.val
            path.append(node.val)

            if not node.left and not node.right and path_sum == target_sum:
                self.result_list.append(path)
            else:
                if node.left:
                    traverse(node.left, path.copy(), path_sum)
                if node.right:
                    traverse(node.right, path.copy(), path_sum)

        self.result_list = []
        traverse(root, [], 0)
        return self.result_list
