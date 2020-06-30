package org.gd.leetcode.p0304;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * @see org.gd.leetcode.p0303.NumArray
 * @since 2019-09-13
 */
@Repeat("Calc sum from range in 2d matrix")
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.DYNAMIC_PROGRAMMING})
class NumMatrix {

    private final Solution solution;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            solution = EmptySolution.INSTANCE;
        } else if (matrix.length == 1) {
            solution = new ArraySolution(matrix[0]);
        } else {
            solution = new DynamicProgrammingSolution(matrix);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return solution.sumRegion(row1, col1, row2, col2);
    }

    private static String toString(int[][] matrix, int[][] sums) {
        StringBuilder sb = new StringBuilder()
                .append('\n')
                .append('\n');
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(String.format("%2d", matrix[i][j])).append(' ');
            }
            sb.append(" --> ");
            for (int j = 0; j < sums[i].length; j++) {
                sb.append(String.format("%2d", sums[i][j])).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    interface Solution {

        int sumRegion(int row1, int col1, int row2, int col2);
    }

    static class EmptySolution implements Solution {

        static final EmptySolution INSTANCE = new EmptySolution();

        private EmptySolution() {}

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) { return 0; }

        @Override
        public String toString() { return "EmptySolution"; }
    }

    static class ArraySolution implements Solution {

        private final int[] sums;

        ArraySolution(int[] nums) {
            sums = Arrays.copyOf(nums, nums.length);
            for (int i = 1; i < nums.length; i++)
                sums[i] += sums[i - 1];
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[col2] - (col1 == 0 ? 0 : sums[col1 - 1]);
        }
    }

    static class QuadSolution implements Solution {

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

    static class LinearMatrixSolution implements Solution {

        private final int[][] matrix;
        private final int[][] sums;

        LinearMatrixSolution(int[][] matrix) {

            this.matrix = matrix;

            sums = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0, sum = 0; j < matrix[i].length; j++) {
                    sums[i][j] = sum += matrix[i][j];
                }
            }
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                int s1 = sums[i][col2];
                int s2 = col1 > 0 ? sums[i][col1 - 1] : 0;
                sum += s1 - s2;
            }
            return sum;
        }

        @Override
        public String toString() {
            return NumMatrix.toString(matrix, sums);
        }
    }

    static class DynamicProgrammingSolution implements Solution {

        private final int[][] matrix;
        private final int[][] sums;

        DynamicProgrammingSolution(int[][] matrix) {

            this.matrix = matrix;

            int rows = matrix.length;
            int cols = matrix[0].length;

            sums = new int[rows][cols];

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++)
                    sums[i][j] += matrix[i][j] + (j > 0 ? sums[i][j - 1] : 0);

                for (int j = 0; i > 0 && j < cols; j++)
                    sums[i][j] += sums[i - 1][j];

            }
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1--;
            col1--;
            return sums[row2][col2]
                    - (row1 >= 0 ? sums[row1][col2] : 0)
                    - (col1 >= 0 ? sums[row2][col1] : 0)
                    + (row1 >= 0 && col1 >= 0 ? sums[row1][col1] : 0);
        }

        @Override
        public String toString() {
            return NumMatrix.toString(matrix, sums);
        }
    }
}
