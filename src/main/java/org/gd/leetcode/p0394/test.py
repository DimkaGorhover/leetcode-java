import unittest
from solution import Solution


class MyTestCase(unittest.TestCase):

    def test_something(self):
        test_cases = [
            {'input': "3[a]2[bc]", 'expected': "aaabcbc"},
            {'input': "3[a2[c]]", 'expected': "accaccacc"},
            {'input': "2[abc]3[cd]ef", 'expected': "abcabccdcdcdef"},
            {'input': "abc3[cd]xyz", 'expected': "abccdcdcdxyz"}
        ]

        solution = Solution()

        for test_case in test_cases:
            actual = solution.decodeString(test_case['input'])
            self.assertEqual(test_case['expected'], actual)


if __name__ == '__main__':
    unittest.main()
