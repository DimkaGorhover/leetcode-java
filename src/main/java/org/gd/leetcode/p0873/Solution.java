package org.gd.leetcode.p0873;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;

// @formatter:off
/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 *
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 *
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 *
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 *
 *
 * Note:
 *
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 *
 * @author Gorkhover D.
 * @since 2018-11-04
 */
// @formatter:on
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.ARRAY, LeetCode.Tags.DYNAMIC_PROGRAMMING})
class Solution {

    private static int find(int[] A, int from,
                            int a1, int a2,
                            HashMap<Integer, Integer> index,
                            int fibLength) {
        final int f = a1 + a2, last = A[A.length - 1], pos;
        if (f == last) return fibLength + 1;
        return (f <= last && (pos = index.getOrDefault(f, -1)) > 0)
                ? find(A, pos + 1, a2, A[pos], index, fibLength + 1)
                : fibLength;
    }

    public int lenLongestFibSubseq(int[] A) {
        final int length;
        if (A == null)
            return 0;
        switch (length = A.length) {
            case 0:
            case 1:
            case 2: return 0;
            case 3: return (A[0] + A[1] == A[2]) ? 3 : 0;
        }

        HashMap<Integer, Integer> index = new HashMap<>(A.length - 2);
        for (int i = 2; i < A.length; i++)
            index.put(A[i], i);

        int max = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                max = Math.max(max, find(A, j + 1, A[i], A[j], index, 0));
            }
        }

        return max > 0 ? max + 2 : 0;
    }
}
