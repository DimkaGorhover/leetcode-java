package org.gd.leetcode.p0477;

/**
 * TODO: https://leetcode.com/problems/total-hamming-distance/
 *
 * @author Gorkhover D.
 * @since 2018-11-05
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
                limit = bits(r),
                length = 0;
        for (int i = 0; i < limit; i++)
            length += (r >> i) & 1;
        return length;

    }

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        switch (nums.length) {
            case 1: return 0;
            case 2: return hammingDistance(nums[0], nums[1]);
        }
        int length = hammingDistance(nums[0], nums[1]);
        for (int i = 1; i < nums.length - 1; i++)
            length += hammingDistance(nums[i], nums[i + 1]);
        return length;
    }
}
