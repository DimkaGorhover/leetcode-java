from typing import List, Dict
import unittest


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache: Dict[int, int] = {}
        i = 0
        while i < len(nums):
            diff = target - nums[i]
            if diff in cache:
                return [cache[diff], i]
            cache[nums[i]] = i
            i += 1
        return [-1, -1]


class SolutionTest(unittest.TestCase):

    def test(self):  # test method names begin with 'test'

        actual = Solution().twoSum([7, 11, 15, 2], 9)
        expected = [0, 3]

        self.assertEqual(expected, actual)


if __name__ == '__main__':
    unittest.main()
