class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def __init__(self):
        self.__max_val = 0

    def maxPathSum(self, root: TreeNode) -> int:
        self.__max_val = -(1 << 31)

        def calc_path(node: TreeNode) -> int:
            if not node:
                return 0

            left_path = max(0, calc_path(node.left))
            rigth_path = max(0, calc_path(node.right))

            self.__max_val = max(self.__max_val, left_path + rigth_path + node.val)

            return max(left_path, rigth_path) + node.val

        calc_path(root)
        return self.__max_val
