from typing import List


class Solution:

    def maximumProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0

        if len(nums) == 1:
            return nums[0]

        if len(nums) == 2:
            return nums[0] * nums[1]

        if len(nums) == 3:
            return nums[0] * nums[1] * nums[3]

        max1 = int(-(1 << 31))
        max2 = int(-(1 << 31))
        max3 = int(-(1 << 31))

        min1 = int((1 << 31) - 1)
        min2 = int((1 << 31) - 1)

        for num in nums:

            if num < min2:
                min2 = num

            if num < min1:
                min2 = min1
                min1 = num

            if num > max3:
                max3 = num

            if num > max2:
                max3 = max2
                max2 = num

            if num > max1:
                max2 = max1
                max1 = num

        return max((min1 * min2 * max1), (max1 * max2 * max3))
