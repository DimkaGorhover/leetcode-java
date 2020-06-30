# https://leetcode.com/problems/fizz-buzz/
from typing import List


class Solution:

    def fizzBuzz(self, n: int):
        list: List[str] = []
        i: int = 1
        while i <= n:
            if i % 3 == 0:
                if i % 5 == 0:
                    list.append("FizzBuzz")
                else:
                    list.append("Fizz")
            else:
                if i % 5 == 0:
                    list.append("Buzz")
                else:
                    list.append(str(i))
            i += 1

        return list


sol = Solution()
print(str(sol.fizzBuzz(15)))
