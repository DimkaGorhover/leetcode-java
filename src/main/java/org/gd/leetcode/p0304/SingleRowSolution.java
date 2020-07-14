package org.gd.leetcode.p0304;

import java.util.Arrays;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
class SingleRowSolution implements Solution {

    private final int[] sums;

    SingleRowSolution(int[] nums) {
        sums = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++)
            sums[i] += sums[i - 1];
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[col2] - (col1 == 0 ? 0 : sums[col1 - 1]);
    }
}
