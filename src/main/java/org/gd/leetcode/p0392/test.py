import unittest
from solution import Solution


class MyTestCase(unittest.TestCase):

    def test_something(self):

        self.assertTrue(Solution().isSubsequence("abc", "ahbgdc"))
        self.assertTrue(Solution().isSubsequence("ac", "ahbgdc"))


if __name__ == '__main__':
    unittest.main()
