# https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution:
    
     def searchMatrix(self, matrix, target: int):

        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        
        cols: int = len(matrix)
        rows: int = len(matrix[0])

        if (matrix[0][0] > target) or (matrix[-1][-1] < target):
            return False

        col: int = 0
        row: int = rows - 1

        while col < cols and row >= 0:

            if matrix[col][row] == target:
                return True

            if matrix[col][row] < target:
                col += 1
            else:
                row -= 1

        return False


matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

assert not Solution().searchMatrix([[]], 9)
assert Solution().searchMatrix(matrix, 9)
assert Solution().searchMatrix(matrix, 10)
assert not Solution().searchMatrix(matrix, 25)
