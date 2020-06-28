import unittest
from solution import Solution


class MyTestCase(unittest.TestCase):
    def test_something(self):
        test_cases = [
            {'expected': 14, 'input': [14]},
            {'expected': 24, 'input': [1, 2, 3, 4]},
        ]

        for test_case in test_cases:
            expected = test_case['expected']
            actual = Solution().maximumProduct(test_case['input'])

            self.assertEqual(expected, actual, F"expected = {expected} actual = {actual} input = {test_case['input']}")


if __name__ == '__main__':
    unittest.main()
