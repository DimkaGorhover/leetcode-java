package org.gd.leetcode.p0905;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-21
 */
@LeetCode(
        name = "Sort Array By Parity",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length <= 1)
            return A;
        for (int i = 0, j = 0; i < A.length; i++) {
            int num = A[i];
            if ((num & 1) != 1) {
                A[i] = A[j];
                A[j] = num;
                j++;
            }
        }
        return A;
    }
}
