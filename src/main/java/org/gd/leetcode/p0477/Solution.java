package org.gd.leetcode.p0477;

/**
 * https://leetcode.com/problems/total-hamming-distance/
 *
 * @author Gorkhover D.
 * @since 2018-11-05
 * <p>
 * https://leetcode.com/submissions/detail/187467808/testcase/
 */
class Solution {

    static int bits(int r) {
        if (r == 0) return 0;
        if (r < Byte.MAX_VALUE) return Byte.SIZE;
        if (r < Short.MAX_VALUE) return Short.SIZE;
        return Integer.SIZE;
    }

    static int hammingDistance(int i1, int i2) {
        int r = i1 ^ i2,
                length = 0;
        for (int i = 0; i < bits(r); i++)
            length += (r >> i) & 1;
        return length;
    }

    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < Integer.SIZE - 1; j++) {
            int bitCount = 0;
            for (int i = 0; i < n; i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
