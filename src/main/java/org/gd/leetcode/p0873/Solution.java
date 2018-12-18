package org.gd.leetcode.p0873;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * @author Gorkhover D.
 * @since 2018-11-04
 */
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
        for (int i = 0; i < length - 2; i++)
            for (int j = i + 1; j < length - 1; j++)
                max = Math.max(max, find(A, j + 1, A[i], A[j], index, 0));
        return max > 0 ? max + 2 : 0;
    }
}
