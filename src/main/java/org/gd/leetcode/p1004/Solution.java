package org.gd.leetcode.p1004;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0485.Solution
 * @since 2020-10-23
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        name = "Max Consecutive Ones III",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.SLIDING_WINDOW
        }
)
class Solution {

    private static int longestSubSeq(final int[] A) {
        int count = 0;
        int max = 0;
        for (int value : A) {
            if (value != 0) {
                max = Math.max(max, ++count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    public int longestOnes(final int[] A, final int K) {

        final int length;
        if (A == null || (length = A.length) == 0)
            return 0;

        if (length == 1)
            return A[0] == 1 || K > 1 ? 1 : 0;

        if (K <= 0)
            return longestSubSeq(A);

        int i = 0, j = 0;
        int count = 0, max = 0;
        int zeros = K;
        while (i < length && j < length) {

            while (j < length) {
                if (A[j] == 0) {
                    if (zeros == 0)
                        break;
                    zeros--;
                }
                count++;
                j++;
            }

            max = Math.max(max, count);

            if (A[i++] == 0)
                zeros++;

            count--;
        }
        return max;
    }
}
