package org.gd.leetcode.p0048;

import org.gd.common.CollectionUtils;

/**
 * TODO: https://leetcode.com/problems/rotate-image/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-12
 */
class Solution {

    public void rotate(int[][] matrix) {


        int t1, t2, t3, t4, length = matrix.length, last = length - 1;
        for (int start = 0; start < length / 2; start++) {

            for (int i = start; i < last; i++) {

                t1 = matrix[start][i];
                t2 = matrix[i][last];
                t3 = matrix[last][last - i];
                t4 = matrix[last - i][start];

                matrix[start][i] = t4;
                matrix[i][last] = t1;
                matrix[last][last - i] = t2;
                matrix[last - i][start] = t3;
            }

            System.out.println(CollectionUtils.listOf(matrix));

            last--;
        }
    }
}
