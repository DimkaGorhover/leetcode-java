class Solution:

    def maxSubArray(self, nums: List[int]) -> int:
        max0 = nums[0]
        max1 = nums[0]
        i = 1
        n = len(nums)
        while i < n:
            max1 = max(max1 + nums[i], nums[i])
            max0 = max(max0, max1)
            i += 1
        return max0
