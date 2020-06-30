class Solution:

    def isUgly(self, num: int) -> bool:
        i = 2
        while i <= 5 and num > 0:
            while (num % i) == 0:
                num /= i
            i += 1

        return num == 1
