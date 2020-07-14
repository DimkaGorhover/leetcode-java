package org.gd.leetcode.p0304;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
class Utils {

    private Utils() { throw new UnsupportedOperationException(); }

    static String toString(int[][] matrix, int[][] sums) {
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
}
