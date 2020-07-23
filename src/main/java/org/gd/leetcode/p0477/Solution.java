package org.gd.leetcode.p0477;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/total-hamming-distance/
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0191.Solution
 * @see org.gd.leetcode.p0461.Solution
 * @see org.gd.leetcode.p0693.Solution
 * @since 2018-11-05
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        name = "Total Hamming Distance",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.MATH,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    private static int hammingDistance(int x, int y) {
        if (x == y)
            return 0;

        int distance = 0;
        while (x > 0 || y > 0) {
            distance += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return distance;
    }

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        if (nums.length == 2)
            return hammingDistance(nums[0], nums[1]);

        int total = 0, n = nums.length;
        for (int j = 0; j < Integer.SIZE; j++) {

            int bitCount = 0;
            for (int num : nums)
                bitCount += (num >> j) & 1;

            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
