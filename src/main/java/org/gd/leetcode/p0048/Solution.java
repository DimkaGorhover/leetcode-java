package org.gd.leetcode.p0048;

/**
 * https://leetcode.com/problems/rotate-image/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-12
 */
class Solution {

    public void rotate(int[][] matrix) {

        int t1, t2, t3, t4,
                length = matrix.length,
                start = 0,
                last = length - 1;

        while (start < matrix.length / 2) {

            for (int i = 0; i < length - 1; i++) {

                t1 = matrix[start][start + i];
                t2 = matrix[start + i][last];
                t3 = matrix[last][last - i];
                t4 = matrix[last - i][start];

                matrix[start][start + i] = t4;
                matrix[start + i][last] = t1;
                matrix[last][last - i] = t2;
                matrix[last - i][start] = t3;
            }

            start++;
            last--;
            length -= 2;
        }
    }
}
