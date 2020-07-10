import unittest
from BrowserHistory import BrowserHistory


class MyTestCase(unittest.TestCase):

    def test_something(self):
        bh = BrowserHistory("leetcode.com")

        bh.visit("google.com")
        bh.visit("facebook.com")
        bh.visit("youtube.com")

        self.assertEqual("facebook.com", bh.back(1))
        self.assertEqual("google.com", bh.back(1))
        self.assertEqual("facebook.com", bh.forward(1))

        bh.visit("linkedin.com")

        self.assertEqual("linkedin.com", bh.forward(2))
        self.assertEqual("google.com", bh.back(2))
        self.assertEqual("leetcode.com", bh.back(7))


if __name__ == '__main__':
    unittest.main()
