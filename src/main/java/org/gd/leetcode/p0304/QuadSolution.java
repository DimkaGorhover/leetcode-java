package org.gd.leetcode.p0304;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 * @deprecated too slow
 */
@Deprecated
class QuadSolution implements Solution {

    private final int[][] nums;

    public QuadSolution(int[][] nums) {
        this.nums = nums;
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += nums[i][j];
            }
        }
        return sum;
    }
}
