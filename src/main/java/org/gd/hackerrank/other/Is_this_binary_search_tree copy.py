"""
https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/
"""

class Node:

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def checkBST(root: Node):

    queue = []
    queue.append([root, 0, 10**4])

    while len(queue) > 0:

        entry = queue.pop()

        root = entry[0]
        min_val = entry[1]
        max_val = entry[2]

        if min_val > root.data or root.data > max_val:
            return False
        
        if root.left:
            queue.append([root, min_val, root.data - 1])

        if root.right:
            queue.append([root, root.data + 1, max_val])

    return True
