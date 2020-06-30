class TreeNode:

    def __init__(self,
                 val: int = 0,
                 left=None,
                 right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def __init__(self):
        self.ans = 0

    def longestUnivaluePath(self, root: TreeNode) -> int:
        self.ans = 0

        def is_eq(parent: TreeNode, child: TreeNode):
            return parent and child and parent.val == child.val

        def lup(node: TreeNode) -> int:
            if not node:
                return 0

            left_root = lup(node.left)
            right_root = lup(node.right)

            left = left_root + 1 if is_eq(node, node.left) else 0
            right = right_root + 1 if is_eq(node, node.right) else 0

            self.ans = max(self.ans, right + left)

            return max(right, left)

        lup(root)

        return self.ans


test_cases = [
    {'expected': 0, 'node': TreeNode(val=10)},
    {'expected': 2, 'node': TreeNode(val=10,
                                     left=TreeNode(10),
                                     right=TreeNode(10))},
    {'expected': 0, 'node': TreeNode(val=10,
                                     left=TreeNode(11),
                                     right=TreeNode(12))}
]

s = Solution()
for test_case in test_cases:
    expected = test_case['expected']

    actual = s.longestUnivaluePath(test_case['node'])
    assert actual == expected, F"expected = {expected}; actual = {actual}"

    actual = Solution().longestUnivaluePath(test_case['node'])
    assert actual == expected, F"expected = {expected}; actual = {actual}"
