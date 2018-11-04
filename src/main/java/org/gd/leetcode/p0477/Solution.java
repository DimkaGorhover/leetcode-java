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

    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < Integer.SIZE; j++) {
            int bitCount = 0;
            for (int i = 0; i < n; i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
