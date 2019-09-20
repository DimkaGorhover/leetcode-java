package org.gd.leetcode.p0304;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * @see org.gd.leetcode.p0303.NumArray
 * @since 2019-09-13
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.DYNAMIC_PROGRAMMING})
class NumMatrix {

    private final Delegate delegate;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            delegate = EmptyDelegate.INSTANCE;
        } else if (matrix.length == 1) {
            delegate = new SingleDelegate(matrix[0]);
        } else {
            delegate = new LinearDelegate(matrix);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return delegate.sumRegion(row1, col1, row2, col2);
    }

    interface Delegate {

        int sumRegion(int row1, int col1, int row2, int col2);
    }

    static class EmptyDelegate implements Delegate {

        static final EmptyDelegate INSTANCE = new EmptyDelegate();

        private EmptyDelegate() {}

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) { return 0; }

        @Override
        public String toString() { return "EmptyDelegate"; }
    }

    static class SingleDelegate implements Delegate {

        private final int[] sums;

        SingleDelegate(int[] nums) {
            sums = new int[nums.length];
            for (int i = 0, sum = 0; i < nums.length; i++)
                sums[i] = (sum += nums[i]);
        }

        @Override
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[col2] - (col1 == 0 ? 0 : sums[col1 - 1]);
        }
    }

    static class LinearDelegate implements Delegate {

        private final int[][] matrix;
        private final int[][] sums;

        LinearDelegate(int[][] matrix) {

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
            //System.out.println(toString());
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                int s1 = sums[i][col2];
                int s2 = col1 > 0 ? sums[i][col1 - 1] : 0;
                //System.out.printf("%2d - %2d = %d%n", s1, s2, s1-s2);
                sum += s1 - s2;
            }
            return sum;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder()
                    .append('\n')
                    .append(getClass().getSimpleName())
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
    }
}
