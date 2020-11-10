package org.gd.leetcode.p0832;

import org.gd.leetcode.common.LeetCode;

/**
 * <a href="https://leetcode.com/problems/flipping-an-image/" target="_blank">832. Flipping an Image</a>
 *
 * @author Horkhover D.
 * @since 2020-11-10
 */
@LeetCode(
        name = "Flipping an Image",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    private static void swap(int[] arr, int i, int j) {
        final int v1 = arr[i] ^ 1;
        final int v2 = arr[j] ^ 1;
        arr[i] = v2;
        arr[j] = v1;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0)
            return A;

        for (final int[] arr : A) {
            final int cols = arr.length;
            final int half = (cols >> 1);
            for (int i = 0, j = cols - 1; i < half; i++, j--) {
                swap(arr, i, j);
            }
            if (cols % 2 != 0) {
                arr[half] ^= 1;
            }
        }
        return A;
    }
}
